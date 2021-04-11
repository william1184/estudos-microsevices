package br.com.unlimitedapps.application;

import br.com.unlimitedapps.domain.FactoryUsuario;
import br.com.unlimitedapps.domain.UsuarioModel;
import lombok.Data;

@Data
public class UsuarioAlterarForm{
	
	private String cpf;
	private String nome;
	private String urlImagem;
	
	public UsuarioModel converter() {
		return FactoryUsuario.builder().comCPFEmailNomeSenha(cpf, nome, urlImagem).build();
	}
	
}
