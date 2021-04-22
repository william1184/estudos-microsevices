package br.com.unlimitedapps.mock;

import br.com.unlimitedapps.domain.Cnpj;

public class CnpjMock {

	public static final String CNPJ_INVALIDO_COM_QUANTIDADE_MAIOR = "106809020001701";
	public static final String CNPJ_INVALIDO_COM_LETRA = "10.680.902/00017A";
	public static final String CNPJ_VALIDO_COM_MASCARA = "10.680.902/0001-70";
	public static final String CNPJ_VALIDO_SEM_MASCARA = "10680902000170";

	
	
	public static Cnpj mockCNPJValidoComMascara() {
		return new Cnpj(CNPJ_VALIDO_COM_MASCARA);
	}
	
	public static Cnpj mockCNPJValidoSemMascara() {
		return new Cnpj(CNPJ_VALIDO_SEM_MASCARA);
	}
	
	public static Cnpj mockCNPJInvalidoQuantidadeMaior() {
		return new Cnpj(CNPJ_INVALIDO_COM_QUANTIDADE_MAIOR);
	}
	
	public static Cnpj mockCNPJInvalidoComLetras() {
		return new Cnpj(CNPJ_INVALIDO_COM_LETRA);
	}
	
	public static Cnpj mockCNPJInvalidoComVazio() {
		return new Cnpj("");
	}
	
	public static Cnpj mockCNPJInvalidoComNulo() {
		return new Cnpj(null);
	}
	
	
}
