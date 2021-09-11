package com.vm.shorturl.exception;

public class InvalidUrlException extends Exception {

    public InvalidUrlException() {
        super();
    }

    public InvalidUrlException(String message) {
        super(message);
    }
}
