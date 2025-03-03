package com.ximple.library.exception;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class NotFoundException extends LibraryException {

    public NotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
