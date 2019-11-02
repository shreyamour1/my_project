package com.radiusAgent.demo.errorhandling;

public class MissingMandatoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MissingMandatoryException(String msg) {
		super(msg);
	}
}
