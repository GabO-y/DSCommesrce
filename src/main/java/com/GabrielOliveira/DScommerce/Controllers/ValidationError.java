package com.GabrielOliveira.DScommerce.Controllers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private List<FieldsError> validationErros = new ArrayList<>();

    public ValidationError(Instant timestamp, String validationErros, Integer status, String path) {
        super(timestamp, validationErros, status, path);
    }

    public List<FieldsError> getErrors() {
        return validationErros;
    }

    public void addErro(String name, String message) {
        validationErros.add(new FieldsError(name, message));
    }


}
