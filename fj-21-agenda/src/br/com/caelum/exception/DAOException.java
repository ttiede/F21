package br.com.caelum.exception;

public class DAOException extends RuntimeException {
	public DAOException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
