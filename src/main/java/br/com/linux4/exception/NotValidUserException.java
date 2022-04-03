package br.com.linux4.exception;

public class NotValidUserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7501289111678791239L;

	public NotValidUserException() {

	}

	public NotValidUserException(String messege) {
		super(messege);
	}

	public NotValidUserException(Throwable cause) {
		super(cause);
	}

	public NotValidUserException(String messege, Throwable cause) {
		super(messege, cause);
	}

}
