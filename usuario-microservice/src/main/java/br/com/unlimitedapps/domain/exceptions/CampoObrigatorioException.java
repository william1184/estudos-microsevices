package br.com.unlimitedapps.domain.exceptions;

public class CampoObrigatorioException extends RuntimeException {
	private static final long serialVersionUID = -1725645774454311009L;
	
	public CampoObrigatorioException(String mensagem) {
		super(mensagem);
	}
}
