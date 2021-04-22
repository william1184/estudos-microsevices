package br.com.unlimitedapps.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;
import br.com.unlimitedapps.mock.EmailMock;

class EmailTest {


	@Test
	void deveRetornarComoEmailValido() {
		Email emailComBR = EmailMock.mockEMAILValidoComBR();
		
		Assertions.assertEquals(EmailMock.EMAIL_VALIDO_EMAIL_COM_BR, emailComBR.getEndereco());
		
		Email emailSemBR =EmailMock.mockEMAILValidoSemBR();
		
		Assertions.assertEquals(EmailMock.EMAIL_VALIDO_EMAIL_SEM_BR, emailSemBR.getEndereco());
	}
	
	@Test
	void deveRetornarComoEmailInvalido() {
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			EmailMock.mockEMAILInvalidoSemArroba()
		);
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			EmailMock.mockEMAILInvalidoComVazio()
		);
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			EmailMock.mockEMAILInvalidoComNulo()
		);
		
	}

}
