package br.com.unlimitedapps.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;

class CpfTest {

	public static final String CPF_INVALIDO_2 = "111111111111";
	public static final String CPF_INVALIDO_1 = "1111111111i";
	public static final String CPF_VALIDO_COM_MASCARA = "111.111.111-11";
	public static final String CPF_VALIDO_SEM_MASCARA = "11111111111";

	@Test
	void deveRetornarComoCPFValidoComMascara() {
		Cpf cpf = new Cpf(CPF_VALIDO_COM_MASCARA);
		
		Assertions.assertEquals(CPF_VALIDO_SEM_MASCARA, cpf.getNumero());
	}
	
	@Test
	void deveRetornarComoCPFValidoSemMascara() {
		Cpf cpf = new Cpf(CPF_VALIDO_SEM_MASCARA);
		
		Assertions.assertEquals(CPF_VALIDO_SEM_MASCARA, cpf.getNumero());
	}
	
	@Test
	void deveRetornarComoCPFInvalido() {
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Cpf(CPF_INVALIDO_1);
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Cpf(CPF_INVALIDO_2);
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Cpf("");
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Cpf(null);
		});
		
	}

}
