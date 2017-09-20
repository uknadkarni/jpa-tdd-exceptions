package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StockNotSavedException extends RuntimeException {

	public StockNotSavedException() {
		// TODO Auto-generated constructor stub
	}

	public StockNotSavedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StockNotSavedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public StockNotSavedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StockNotSavedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
