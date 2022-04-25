package br.com.williamdev.apcoders.exception;

public class ControllerNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ControllerNotFoundException(Object id) {
		super("Resource not found Id " + id);
	}

}
