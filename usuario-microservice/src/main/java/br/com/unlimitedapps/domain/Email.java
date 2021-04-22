package br.com.unlimitedapps.domain;


import java.util.regex.Pattern;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Email {
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
	
	@Getter
	private String endereco;

	public Email(String endereco) {
		if(endereco == null || !VALID_EMAIL_ADDRESS_REGEX.matcher(endereco).matches()) {
			throw new CampoInvalidoException("Email com formato invalido.");
		}
		this.endereco = endereco;
	}


}
