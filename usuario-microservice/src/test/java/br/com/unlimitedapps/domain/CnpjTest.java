package br.com.unlimitedapps.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;

class CnpjTest {

	public static final String CNPJ_INVALIDO_2 = "10680902000170";
	public static final String CNPJ_INVALIDO_1 = "10.680.902/000170";
	public static final String CNPJ_VALIDO = "10.680.902/0001-70";

	@Test
	void deveRetornarComoCNPJValido() {
		Cnpj cnpj = new Cnpj(CNPJ_VALIDO);
		
		Assertions.assertEquals(CNPJ_VALIDO, cnpj.getNumero());
	}
	
	@Test
	void deveRetornarComoCNPJInvalido() {
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Cnpj(CNPJ_INVALIDO_1);
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Cnpj(CNPJ_INVALIDO_2);
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Cnpj("");
		});
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> {
			new Cnpj(null);
		});
		
	}
}
