package com.task.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    String enteredValue;

    public ResourceNotFoundException(String resourceName, String fieldName, String enteredValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, enteredValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.enteredValue = enteredValue;
    }

}
