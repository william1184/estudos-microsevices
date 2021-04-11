package br.com.unlimitedapps.domain;


import java.util.regex.Pattern;

import br.com.unlimitedapps.common.CommonUtils;
import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;
import lombok.Getter;

public class Cpf {
	private static final Pattern VALID_CPF_ADDRESS_REGEX_COM_MASCARA = Pattern.compile("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)");
	private static final Pattern VALID_CPF_ADDRESS_REGEX_SEM_MASCARA = Pattern.compile("(^\\d{11}$)");
	
	@Getter
	private final String numero;

	/**
	 * Devolve o numero do cpf
	 * @param String numero ( sem mascara )
	 */
	public Cpf(String numero) {
		if(numero == null || ( !VALID_CPF_ADDRESS_REGEX_COM_MASCARA.matcher(numero).matches() && !VALID_CPF_ADDRESS_REGEX_SEM_MASCARA.matcher(numero).matches() ) ) {
			throw new CampoInvalidoException("CPF Invalido");
		}
		this.numero = CommonUtils.removeFormatacao(numero);			
	}

	

	/**
	 * Devolve o numero do cpf
	 * @param String numero ( com mascara )
	 */
	public String getNumeroComMascara() {
		return CommonUtils.formataCPF(numero);
	}
	
}
