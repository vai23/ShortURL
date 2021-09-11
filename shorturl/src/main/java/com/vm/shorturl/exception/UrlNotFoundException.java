package com.vm.shorturl.exception;

public class UrlNotFoundException extends Exception {

    public UrlNotFoundException() {
        super();
    }

    public UrlNotFoundException(String message) {
        super(message);
    }
}
