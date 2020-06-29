package com.czh.seck.exception;

public class RepeatedKillException extends ExecutionException {

    public RepeatedKillException(String message) {
        super(message);
    }

    public RepeatedKillException(String message, Throwable cause) {
        super(message, cause);
    }

}
