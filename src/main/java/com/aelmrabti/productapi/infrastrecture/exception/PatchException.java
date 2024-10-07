package com.aelmrabti.productapi.infrastrecture.exception;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PatchException extends RuntimeException {
    public PatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
