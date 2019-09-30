package com.cg.moviesforyou.exception;

public class DateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3977846202010369459L;

	public DateException() {
		super();
	}

	public DateException(String message) {
		super(message);
	}

	public DateException(Throwable cause) {
		super(cause);
	}

	public DateException(String message, Throwable cause) {
		super(message, cause);
	}

	public DateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}