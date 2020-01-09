package com.epam.infoHandling.exception;

public class SortException extends Exception{
    public SortException() {
    }

    public SortException(String message) {
        super(message);
    }

    public SortException(String message, Throwable cause) {
        super(message, cause);
    }

    public SortException(Throwable cause) {
        super(cause);
    }
}
