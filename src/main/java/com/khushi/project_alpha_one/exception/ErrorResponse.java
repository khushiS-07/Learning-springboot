package com.khushi.project_alpha_one.exception;

public record ErrorResponse(
		String timestamp,
		int status,
		String error,
		String message,
		String path) 
{ }
