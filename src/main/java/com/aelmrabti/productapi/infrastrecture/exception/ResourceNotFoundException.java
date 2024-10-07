package com.aelmrabti.productapi.infrastrecture.exception;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceNotFoundException extends RuntimeException {

    private final Class<?> clazz;
    private final Long id;

    public ResourceNotFoundException(Class<?> clazz, Long id) {
        this.clazz = clazz;
        this.id = id;
        log.error("{} not found for id : {}", clazz.getSimpleName(), id);
    }

    @Override
    public String getMessage() {
        return String.format("%s not found for id : %d", this.clazz.getSimpleName(), this.id);
    }
}
