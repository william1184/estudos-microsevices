package br.com.unlimitedapps.common;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.FormatoInvalidoException;
import br.com.unlimitedapps.mock.CnpjMock;
import br.com.unlimitedapps.mock.CpfMock;

class CommonUtilsTest {

	@Test
	void validarMetodoFormataCPF() {
		Assertions.assertEquals(CpfMock.CPF_VALIDO_SEM_MASCARA, CommonUtils.formataCPF(CpfMock.CPF_VALIDO_SEM_MASCARA) );
	
		Assertions.assertThrows(FormatoInvalidoException.class, () -> 
			{
				CommonUtils.formataCPF(CpfMock.CPF_INVALIDO_QUANTIDADE_MAIOR);
			}
		, "Deveria dar erro pois cpf está incorreto");
	}
	
	@Test
	void validarMetodoFormataCNPJ() {
		Assertions.assertEquals(CnpjMock.CNPJ_VALIDO_COM_MASCARA, CommonUtils.formataCNPJ(CnpjMock.CNPJ_VALIDO_SEM_MASCARA) );
		String substring = CnpjMock.CNPJ_VALIDO_COM_MASCARA.substring(0, 5);
		
		Assertions.assertThrows(FormatoInvalidoException.class, () -> {
			CommonUtils.formataCPF(substring);
		}, "Deveria dar erro pois CNPJ está incorreto");
	}
	
	@Test
	void deveRemoverFormatacao() {
		Assertions.assertEquals(	  CnpjMock.CNPJ_VALIDO_SEM_MASCARA
									, CommonUtils.removeFormatacao(CnpjMock.CNPJ_VALIDO_COM_MASCARA));
			
	}
	
	@Test
	void deveRetornarLocalDateEmString() {
			LocalDate data = LocalDate.now();
			
			String converterLocalDateToString = CommonUtils.converterLocalDateToString(data);
			String[] anoMesDia = converterLocalDateToString.split("-");
			
			Assertions.assertEquals(data.getYear(), Integer.parseInt( anoMesDia[0] ));
			Assertions.assertEquals(data.getMonthValue(), Integer.parseInt( anoMesDia[1] ));
			Assertions.assertEquals(data.getDayOfMonth(), Integer.parseInt( anoMesDia[2] ));
	}

}
