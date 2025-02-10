package com.GabrielOliveira.DScommerce.Controllers;

public class FieldsError {

    private String fieldName;
    private String message;

    public FieldsError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
