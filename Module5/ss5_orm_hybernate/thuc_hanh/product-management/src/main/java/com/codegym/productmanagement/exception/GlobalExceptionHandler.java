package com.codegym.productmanagement.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            BindException.class,
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class,
            IllegalArgumentException.class,
            NumberFormatException.class
    })
    public String handleBadRequest(Exception ex) {
        ex.printStackTrace();
        return "error/400";
    }

    @ExceptionHandler({
            NoResultException.class,
            EntityNotFoundException.class,
            NoHandlerFoundException.class
    })
    public String handleNotFound(Exception ex) {
        ex.printStackTrace();
        return "error/404";
    }

    @ExceptionHandler(Exception.class)
    public String handleServerError(Exception ex) {
        ex.printStackTrace();
        return "error/500";
    }
}