package br.com.unlimitedapps.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UsuarioJaExisteException extends RuntimeException {
	private static final long serialVersionUID = 4396973354447982705L;

	public UsuarioJaExisteException(String item) {
	    super("Usuario já existe : " + item);
	}
	
	@ResponseBody
	@ExceptionHandler(UsuarioJaExisteException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String handler(UsuarioJaExisteException ex) {
		return ex.getMessage();
	}
}
