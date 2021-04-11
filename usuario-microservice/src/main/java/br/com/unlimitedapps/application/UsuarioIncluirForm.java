package br.com.unlimitedapps.application;

import br.com.unlimitedapps.domain.FactoryUsuario;
import br.com.unlimitedapps.domain.UsuarioModel;

public class UsuarioIncluirForm {
	
	private String email;
	private String senha;
	private String nome;
	private String urlImagem;
	private String cpf;
	
	public UsuarioIncluirForm() {
	}
	
	public UsuarioIncluirForm(String email, String senha, String nome, String cpf) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public UsuarioIncluirForm setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getSenha() {
		return senha;
	}
	public UsuarioIncluirForm setSenha(String senha) {
		this.senha = senha;
		return this;
	}
	public String getNome() {
		return nome;
	}
	public UsuarioIncluirForm setNome(String nome) {
		this.nome = nome;
		return this;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public UsuarioIncluirForm setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
		return this;
	}
	public String getCpf() {
		return cpf;
	}
	
	public UsuarioIncluirForm setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public UsuarioModel converter() {
		return FactoryUsuario.builder().comCPFEmailNomeSenha(cpf, email, nome, senha).build();
	}

}
