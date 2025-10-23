package org.serratec.aula09.exception;

public class InscricaoDuplicadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InscricaoDuplicadaException(String message) {
		super(message);
	}

}
