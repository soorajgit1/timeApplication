package com.time.v1.exception;

public class TimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public TimeException(String message) {
		super(message);
		this.message = message;
	}

}
