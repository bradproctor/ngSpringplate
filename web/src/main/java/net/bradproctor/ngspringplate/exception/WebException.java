package net.bradproctor.ngspringplate.exception;

public class WebException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String message;

	public WebException(String message, Throwable cause){
		super(message, cause);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
