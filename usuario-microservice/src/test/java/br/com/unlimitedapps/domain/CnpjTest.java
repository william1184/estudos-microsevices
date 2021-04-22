package br.com.unlimitedapps.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;
import br.com.unlimitedapps.mock.CnpjMock;

class CnpjTest {


	@Test
	void deveRetornarComoCNPJValido() {
		Cnpj cnpj = CnpjMock.mockCNPJValidoComMascara();
		
		Assertions.assertEquals(CnpjMock.CNPJ_VALIDO_COM_MASCARA, cnpj.getNumeroComMascara());
		
		Assertions.assertEquals(CnpjMock.CNPJ_VALIDO_SEM_MASCARA, cnpj.getNumero());
	}
	
	@Test
	void deveRetornarComoCNPJInvalido() {
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			CnpjMock.mockCNPJInvalidoComLetras();
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			CnpjMock.mockCNPJInvalidoQuantidadeMaior();
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			CnpjMock.mockCNPJInvalidoComVazio();
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			CnpjMock.mockCNPJInvalidoComNulo();
		});
		
	}
}
