package com.enviro.assessment.grad001.KaraboMashao.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundExceptions ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode().toString(), ex.getMessage(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
                                                                        HttpServletRequest request) {
        String detailedMessage = ex.getMostSpecificCause() != null
                ? ex.getMostSpecificCause().getMessage()
                : ex.getMessage();

        ErrorResponse errorResponse = new ErrorResponse("DATA_INTEGRITY_VIOLATION", detailedMessage,
                LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, HttpServletRequest request) {
        ex.printStackTrace();

        String message = "A required value was null. Please check your input and ensure all required fields are provided.";
        ErrorResponse errorResponse = new ErrorResponse("NULL_POINTER_EXCEPTION", message, LocalDateTime.now(),
                request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex, HttpServletRequest request) {
        ex.printStackTrace();

        String message = "URL endpoint does not exist";
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode().toString(), message, LocalDateTime.now(),
                request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        ex.printStackTrace();

        String message = "Request body can not be empty";
        ErrorResponse errorResponse = new ErrorResponse("Http_Message_Not_Readable_Exception", message, LocalDateTime.now(),
                request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        ex.printStackTrace();

        String message = "Invalid type";
        ErrorResponse errorResponse = new ErrorResponse( "Method_Argument_Type_Mismatch_Exception", message, LocalDateTime.now(),
                request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        ex.printStackTrace();

        String message = "Request method 'POST' is not supported";
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode().toString(), message, LocalDateTime.now(),
                request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        ex.printStackTrace();

        String message = "Constraints are violated";
        ErrorResponse errorResponse = new ErrorResponse(ex.getConstraintViolations().toString(), message, LocalDateTime.now(),
                request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }
}

