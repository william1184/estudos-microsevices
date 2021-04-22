package br.com.unlimitedapps.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.unlimitedapps.domain.FactoryUsuario;
import br.com.unlimitedapps.domain.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioIncluirForm {
	
	private String email;
	private String senha;
	private String nome;
	private String urlImagem;
	private String cpf;
	
	public UsuarioIncluirForm(String cpf, String email, String nome, String senha) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Usuario converter() {
		return FactoryUsuario.builder().comCPFEmailNomeSenha(cpf, email, nome, senha).build();
	}
	
	public String converterParaJSON() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

}
