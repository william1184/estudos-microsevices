package br.com.unlimitedapps.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;
import br.com.unlimitedapps.mock.CpfMock;

class CpfTest {

	@Test
	void deveRetornarComoCPFValidoComMascara() {
		Cpf cpf = CpfMock.mockCPFValidoComMascara();
		
		Assertions.assertEquals(CpfMock.CPF_VALIDO_COM_MASCARA, cpf.getNumeroComMascara());
	}
	
	@Test
	void deveRetornarComoCPFValidoSemMascara() {
		Cpf cpf = CpfMock.mockCPFValidoSemMascara();
		
		Assertions.assertEquals(CpfMock.CPF_VALIDO_SEM_MASCARA, cpf.getNumero());
	}
	
	@Test
	void deveRetornarComoCPFInvalido() {
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			CpfMock.mockCPFInvalidoQuantidadeMaior()
		);
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			CpfMock.mockCPFInvalidoComLetras()
		);
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			CpfMock.mockCPFInvalidoComVazio()
		);
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			CpfMock.mockCPFInvalidoComNulo()
		);
		
	}

}
