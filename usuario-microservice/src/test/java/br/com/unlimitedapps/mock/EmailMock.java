package br.com.unlimitedapps.mock;

import br.com.unlimitedapps.domain.Email;

public class EmailMock {

	public static final String EMAIL_VALIDO_EMAIL_COM_BR = "emailValido@email.com.br";
	public static final String EMAIL_VALIDO_EMAIL_SEM_BR = "emailValido@email.com";
	public static final String EMAIL_INVALIDO_EMAIL_COM_BR_SEM_ARROBA = "emailInvalido.email.com.br";
	
	
	public static Email mockEMAILValidoComBR() {
		return new Email(EMAIL_VALIDO_EMAIL_COM_BR);
	}
	
	public static Email mockEMAILValidoSemBR() {
		return new Email(EMAIL_VALIDO_EMAIL_SEM_BR);
	}
	
	public static Email mockEMAILInvalidoSemArroba() {
		return new Email(EMAIL_INVALIDO_EMAIL_COM_BR_SEM_ARROBA);
	}
	
	public static Email mockEMAILInvalidoComVazio() {
		return new Email("");
	}
	
	public static Email mockEMAILInvalidoComNulo() {
		return new Email(null);
	}
}
