package br.com.unlimitedapps.common;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.unlimitedapps.domain.exceptions.FormatoInvalidoException;

public class CommonUtils {
	
	private CommonUtils() {}
	
	/**
	 * Verifica se o texto é vazio ou nulo
	 * @param String
	 * @return boolean
	 */
	public static boolean isTextoNuloOuVazio(String texto) {
		return texto == null || texto.trim().length() == 0;
	}
	
	/**
	 * Verifica se o texto é vazio ou nulo
	 * @param Long
	 * @return boolean
	 */
	public static boolean isTextoNuloOuVazio(Long numeroLong) {
		return isTextoNuloOuVazio(numeroLong.toString());
	}
	
	/**
	 * Formata CPF
	 * @param int
	 * @return String
	 */
	public static String formataCPF(String numeros) {
		
		if(!isTextoNuloOuVazio(numeros) && numeros.length() == 11) {
			
			return MessageFormat.format("{0}.{1}.{2}-{3}" , numeros.substring(0, 3)
														  , numeros.substring(3, 6)
														  ,	numeros.substring(6, 9)
														  , numeros.substring(9, 11)
												);
			
		}
		
		throw new FormatoInvalidoException("CPF");
		
	}
	
	/**
	 * Formata CPF
	 * @param int
	 * @return String
	 */
	public static String formataCNPJ(String numeros) {
		
		if(!isTextoNuloOuVazio(numeros) && numeros.length() == 14) {
			
			return MessageFormat.format("{0}.{1}.{2}/{3}-{4}" , numeros.substring(0, 2)
															  , numeros.substring(2, 5)
															  ,	numeros.substring(5, 8)
															  , numeros.substring(8, 12)
															  , numeros.substring(12, 14)
												);
			
		}
		
		throw new FormatoInvalidoException("CPF");
		
	}
	
	/**
	 * Remove formatacao
	 * @param int
	 * @return String
	 */
	public static String removeFormatacao(String formatado) {
		return formatado.replaceAll("[^\\d]", "");
		
	}

	/**
	 * @param LocalDate data
	 * @param String format
	 * @return String
	 */
	public static String converterLocalDateToString(LocalDate data) {
		return data.format( DateTimeFormatter.ISO_INSTANT );
	}
	
	/**
	 * @param LocalDate data
	 * @param String format
	 * @return String
	 */
	public static String converterLocalDateToString(LocalDate data, String format) {
		return data.format( DateTimeFormatter.ofPattern(format) );
	}
	
	/**
	 * Converter string data em localdateTime
	 * do formato yyyy-mm-dd HH:mm
	 * @param String data
	 * @return LocalDateTime
	 */
	public static LocalDateTime converterStringDataParaLocalDateTime(String data) {
		return LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));	
	}
	
	/**
	 * @param LocalDateTime data
	 * @param String format
	 * @return String
	 */
	public static String converterLocalDateTimeToString(LocalDateTime data) {
		return data.format( DateTimeFormatter.ISO_LOCAL_DATE_TIME );
	}
	
}
