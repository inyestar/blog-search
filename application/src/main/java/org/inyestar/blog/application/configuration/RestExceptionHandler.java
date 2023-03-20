package org.inyestar.blog.application.configuration;

import org.inyestar.blog.domain.exception.SearchBlogException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> handleInternalServerError(RuntimeException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }

    @ExceptionHandler(value = SearchBlogException.class)
    public final ResponseEntity<Object> handleBadRequest(SearchBlogException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
