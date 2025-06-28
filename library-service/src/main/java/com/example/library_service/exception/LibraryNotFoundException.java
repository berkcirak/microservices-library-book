package com.example.library_service.exception;

public class LibraryNotFoundException extends RuntimeException {
    public LibraryNotFoundException(String s) {
        super(s);
    }
}
