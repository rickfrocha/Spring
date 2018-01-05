package com.example.zullGateway.exception;

/**
 * Created by ricardo on 27/12/17.
 */
public class ServiceUnavaliableException extends RuntimeException {

    public ServiceUnavaliableException() {
        super();
    }

    public ServiceUnavaliableException(String message) {
        super(message);
    }

    public ServiceUnavaliableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUnavaliableException(Throwable cause) {
        super(cause);
    }

    protected ServiceUnavaliableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
