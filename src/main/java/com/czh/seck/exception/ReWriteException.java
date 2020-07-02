package com.czh.seck.exception;

public class ReWriteException extends ExecutionException {

    public ReWriteException(String message) {
        super(message);
    }

    public ReWriteException(String message, Throwable cause) {
        super(message, cause);
    }

}
