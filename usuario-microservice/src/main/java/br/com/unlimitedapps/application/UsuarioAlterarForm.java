package br.com.unlimitedapps.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.unlimitedapps.domain.FactoryUsuario;
import br.com.unlimitedapps.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAlterarForm{
	
	private String id;
	private String nome;
	private String urlImagem;
	
	public Usuario converter() {
		return FactoryUsuario.builder().comIdNomeUrlImagem(id, nome, urlImagem).build();
	}
	
	public String converterParaJSON() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
	
}
