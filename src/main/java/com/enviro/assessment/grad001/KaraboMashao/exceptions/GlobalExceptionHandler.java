package com.enviro.assessment.grad001.KaraboMashao.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundExceptions ex) {
        // Create a custom response body without the trace key
        ErrorResponse errorResponse = new ErrorResponse("NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        // Extract the most specific cause and build a user-friendly message
        String detailedMessage = ex.getMostSpecificCause() != null
                ? ex.getMostSpecificCause().getMessage()
                : ex.getMessage();

        ErrorResponse errorResponse = new ErrorResponse("DATA_INTEGRITY_VIOLATION", detailedMessage);

        // Return the complete structured error response
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
        // Log the stack trace or exception details if necessary
        ex.printStackTrace(); // Optional: Use a logger for production

        // Customize the error message
        String message = "A required value was null. Please check your input and ensure all required fields are provided.";
        ErrorResponse errorResponse = new ErrorResponse("NULL_POINTER_EXCEPTION", message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex) {
        // Log the stack trace or exception details if necessary
        ex.printStackTrace(); // Optional: Use a logger for production

        // Customize the error message
        String message = "URL endpoint does not exist";
        ErrorResponse errorResponse = new ErrorResponse("No_Resource_Found_Exception", message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        // Log the stack trace or exception details if necessary
        ex.printStackTrace(); // Optional: Use a logger for production

        // Customize the error message
        String message = "Request body can not be empty";
        ErrorResponse errorResponse = new ErrorResponse("Http_Message_Not_Readable_Exception", message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        // Log the stack trace or exception details if necessary
        ex.printStackTrace(); // Optional: Use a logger for production

        // Customize the error message
        String message = "Mismatch in URL address";
        ErrorResponse errorResponse = new ErrorResponse("Method_Argument_Type_Mismatch_Exception", message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}


// Custom error response class
class ErrorResponse {
    private String errorCode;
    private String message;

    public ErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}