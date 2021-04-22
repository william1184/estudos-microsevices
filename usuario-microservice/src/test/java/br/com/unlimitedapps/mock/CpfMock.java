package br.com.unlimitedapps.mock;

import br.com.unlimitedapps.domain.Cpf;

public class CpfMock {

	public static final String CPF_INVALIDO_QUANTIDADE_MAIOR = "111111111111";
	public static final String CPF_INVALIDO_COM_LETRA = "1111111111i";
	public static final String CPF_VALIDO_COM_MASCARA = "111.111.111-11";
	public static final String CPF_VALIDO_SEM_MASCARA = "11111111111";
	
	
	public static Cpf mockCPFValidoComMascara() {
		return new Cpf(CPF_VALIDO_COM_MASCARA);
	}
	
	public static Cpf mockCPFValidoSemMascara() {
		return new Cpf(CPF_VALIDO_SEM_MASCARA);
	}
	
	public static Cpf mockCPFInvalidoQuantidadeMaior() {
		return new Cpf(CPF_INVALIDO_QUANTIDADE_MAIOR);
	}
	
	public static Cpf mockCPFInvalidoComLetras() {
		return new Cpf(CPF_INVALIDO_COM_LETRA);
	}
	
	public static Cpf mockCPFInvalidoComVazio() {
		return new Cpf("");
	}
	
	public static Cpf mockCPFInvalidoComNulo() {
		return new Cpf(null);
	}
}
