package org.inyestar.blog.api.configuration;

import org.apache.commons.lang3.StringUtils;
import org.inyestar.blog.domain.exception.SearchBlogException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> handleInternalServerError(RuntimeException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }

    @ExceptionHandler(value = SearchBlogException.class)
    public final ResponseEntity<Object> handleBadRequest(SearchBlogException ex) {
        return ResponseEntity.badRequest().body(
            new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage()));
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public final ResponseEntity<ApiErrorResponse> handleValidationError(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body(
            new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .findFirst()
                    .orElse(StringUtils.EMPTY)));
    }
}
