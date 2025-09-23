package com.khushi.project_alpha_one.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.khushi.project_alpha_one.exception.ErrorResponse;

import com.khushi.project_alpha_one.exception.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex, HttpServletRequest req){
		// using record
		ErrorResponse body = new ErrorResponse(
			Instant.now().toString(),
			HttpStatus.NOT_FOUND.value(),
			"Product not found exception",
			ex.getMessage(),
			req.getRequestURI()	
			);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

}

