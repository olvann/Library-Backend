package com.ximple.library.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LibraryException extends RuntimeException {
    public LibraryException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public LibraryException(String message) {
        super(message);
    }
}
