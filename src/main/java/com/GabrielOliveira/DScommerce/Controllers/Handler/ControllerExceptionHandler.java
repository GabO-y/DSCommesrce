package com.GabrielOliveira.DScommerce.Controllers.Handler;

import com.GabrielOliveira.DScommerce.Controllers.CustomError;
import com.GabrielOliveira.DScommerce.Services.Exception.DataBaseException;
import com.GabrielOliveira.DScommerce.Services.Exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        CustomError err = new CustomError(Instant.now(), e.getMessage(), HttpStatus.NOT_FOUND.value(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<CustomError> dataBaseIntegrid(DataBaseException e, HttpServletRequest request) {

        CustomError err = new CustomError(Instant.now(), e.getMessage(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

    }


}
