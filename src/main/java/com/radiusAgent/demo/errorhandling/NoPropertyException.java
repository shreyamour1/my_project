package com.radiusAgent.demo.errorhandling;

public class NoPropertyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoPropertyException(String msg) {
		super(msg);
	}

}
