package org.inyestar.blog.domain.exception;

import java.util.function.Supplier;

public class SearchBlogException extends RuntimeException implements Supplier<RuntimeException> {
    public SearchBlogException(String message) {
        super(message);
    }
    @Override
    public RuntimeException get() {
        return this;
    }
}
