package com.czh.seck.exception;

public class SeckillClosedException extends ExecutionException {

    public SeckillClosedException(String message) {
        super(message);
    }

    public SeckillClosedException(String message, Throwable cause) {
        super(message, cause);
    }

}
