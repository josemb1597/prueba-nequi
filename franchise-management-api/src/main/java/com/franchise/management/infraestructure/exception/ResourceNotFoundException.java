package com.franchise.management.infraestructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    private final String entityName;
    private final Long entityId;

    @Override
    public String getMessage() {
        return String.format("%s with ID %d not found", entityName, entityId);
    }
}