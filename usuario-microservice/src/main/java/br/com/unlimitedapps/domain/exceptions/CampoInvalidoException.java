package br.com.unlimitedapps.domain.exceptions;

public class CampoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = -1725645774454311009L;
	
	public CampoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
