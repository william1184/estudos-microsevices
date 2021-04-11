package br.com.unlimitedapps.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UsuarioNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 6742863916031409826L;

	public UsuarioNaoExisteException(String item) {
	    super("Usuario não encontrado: " + item);
	}
	
	@ResponseBody
	@ExceptionHandler(UsuarioNaoExisteException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String handler(UsuarioNaoExisteException ex) {
		return ex.getMessage();
	}
}
