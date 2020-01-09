package com.epam.infoHandling.exception;

import java.nio.file.NoSuchFileException;

public class ReadFileException extends Exception{
    public ReadFileException() {
    }

    public ReadFileException(String message) {
        super(message);
    }

    public ReadFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadFileException(Throwable cause) {
        super(cause);
    }
}
