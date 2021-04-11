package br.com.unlimitedapps.domain.exceptions;

public class FormatoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = -1725645774454311009L;
	
	public FormatoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
