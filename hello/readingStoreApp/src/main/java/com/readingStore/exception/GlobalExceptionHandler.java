package com.readingStore.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.readingStore.Dto.ErrorResponseDto;
@RestControllerAdvice
public class GlobalExceptionHandler{
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourseNotFound(ResourseNotFoundException e){
		ErrorResponseDto error = new ErrorResponseDto(
									e.getMessage(),
									HttpStatus.NOT_FOUND.value(),
									LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleAllOtherExceptions(ResourseNotFoundException e){
		ErrorResponseDto error = new ErrorResponseDto(
									"Something went Wrong: "+e.getMessage(),
									HttpStatus.NOT_FOUND.value(),
									LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
