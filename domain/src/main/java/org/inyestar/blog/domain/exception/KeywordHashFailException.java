package org.inyestar.blog.domain.exception;

import java.util.function.Supplier;

public class KeywordHashFailException extends RuntimeException implements Supplier<RuntimeException> {
    public KeywordHashFailException() {
        super();
    }
    public KeywordHashFailException(String message) {
        super(message);
    }
    @Override
    public RuntimeException get() {
        return this;
    }
}
