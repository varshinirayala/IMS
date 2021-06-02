package com.mindtree.inventorysystem.exceptions;

public class InsufficientQuantityException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientQuantityException(String message) {
		super(message);
	}

}
