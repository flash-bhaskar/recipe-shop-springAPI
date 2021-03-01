package com.flash.Recipeshop.Exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomErrorDetails handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
		return new CustomErrorDetails(new Date(),"Arguments Not valid",ex.getMessage());
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomErrorDetails handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, WebRequest request) {
		return new CustomErrorDetails(new Date()," Http request method not supported for the request",ex.getMessage());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomErrorDetails handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		return new CustomErrorDetails(new Date()," The Path Variable cannot be zero ",ex.getMessage());
	}
	

}
