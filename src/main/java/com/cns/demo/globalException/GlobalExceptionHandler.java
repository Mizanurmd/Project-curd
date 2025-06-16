package com.cns.demo.globalException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cns.demo.customException.ErrorDetails;
import com.cns.demo.customException.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException ex) {
		ErrorDetails errors = new ErrorDetails(ex.getMessage(), "Resource Not found", LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errors, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGenericException(Exception ex) {
		ErrorDetails errors = new ErrorDetails(ex.getMessage(), "404", LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	  @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ErrorDetails> handleValidationError(MethodArgumentNotValidException ex) {
	        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
	        ErrorDetails error = new ErrorDetails(
	                message,
	                "Validation Error",
	                LocalDateTime.now()
	        );
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }

}
