package br.com.unlimitedapps.domain;

import java.util.regex.Pattern;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;
import lombok.Getter;

public class Cnpj {
	private static final Pattern VALID_CNPJ_ADDRESS_REGEX = Pattern.compile("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)");
	
	@Getter
	private final String numero;

	public Cnpj(String numero) {
		if(numero == null || !VALID_CNPJ_ADDRESS_REGEX.matcher(numero).matches()) {
			throw new CampoInvalidoException("CNPJ Invalido");
		}
		this.numero = numero;			
	}

}