package org.inyestar.blog.api.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> handleInternalServerError(RuntimeException ex) {
        return ResponseEntity.internalServerError().build();
    }

}
