package br.com.unlimitedapps.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;

class EmailTest {

	public static final String EMAIL_VALIDO_EMAIL_COM_BR = "emailValido@email.com.br";
	public static final String EMAIL_INVALIDO_EMAIL_COM_BR = "emailInvalido.email.com.br";

	@Test
	void deveRetornarComoEmailValido() {
		Email email = new Email(EMAIL_VALIDO_EMAIL_COM_BR);
		
		Assertions.assertEquals(EMAIL_VALIDO_EMAIL_COM_BR, email.getEndereco());
	}
	
	@Test
	void deveRetornarComoEmailInvalido() {
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Email(EMAIL_INVALIDO_EMAIL_COM_BR);
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Email("");
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Email(null);
		});
		
	}

}
