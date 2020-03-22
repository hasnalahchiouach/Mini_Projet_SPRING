package Hasna.example.mini_projet.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RessourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RessourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RessourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
