package com.pratilipi.demo.errorhandling;

public class NoStudentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoStudentException(String msg) {
		super(msg);
	}

}
