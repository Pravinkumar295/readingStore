package com.readingStore.Dto;

import java.time.LocalDateTime;

public class ErrorResponseDto {
	private String message;
	private int statusCode;
	private LocalDateTime timeStramp;
	public ErrorResponseDto(String message, int statusCode, LocalDateTime timeStramp) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.timeStramp = timeStramp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getTimeStramp() {
		return timeStramp;
	}
	public void setTimeStramp(LocalDateTime timeStramp) {
		this.timeStramp = timeStramp;
	}
	
	
}
