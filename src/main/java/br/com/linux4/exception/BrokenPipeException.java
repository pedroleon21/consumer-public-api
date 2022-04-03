package br.com.linux4.exception;

public class BrokenPipeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8858450056174629724L;
	private int status;

	public BrokenPipeException() {
		super();
	}

	public BrokenPipeException(String messege) {
		super(messege);
	}

	public BrokenPipeException(Throwable cause) {
		super(cause);
	}

	public BrokenPipeException(String messege, Throwable cause) {
		super(messege, cause);
	}

	public BrokenPipeException(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
