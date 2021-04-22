package br.com.unlimitedapps.domain;


import java.time.LocalDateTime;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;
import br.com.unlimitedapps.domain.exceptions.CampoObrigatorioException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Usuario {

	private String id;
	private Cpf cpf;
	private Email email;
	private String senha;
	private String nome;
	private String urlImagem;
	private TipoUsuario tipo;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataUltimaAlteracao;
	
	public Usuario() {
		this.tipo = TipoUsuario.PADRAO;
		this.dataCriacao = LocalDateTime.now();
		this.dataUltimaAlteracao = LocalDateTime.now();
	}
	
	public Usuario(Cpf cpf, Email email, String nome, String senha) {
		this();
		if(cpf == null) {
			throw new CampoObrigatorioException("O campo cpf e obrigatorio!");
		}
		
		if(email == null) {
			throw new CampoObrigatorioException("O campo email e obrigatorio!");
		}
		
		if(nome == null || nome.isEmpty() ) {
			throw new CampoObrigatorioException("O campo nome e obrigatorio!");
		}
		
		if(nome.length() < 5) {
			throw new CampoInvalidoException("O nome esta invalido!");
		}
		
		if(senha == null || senha.isEmpty() ) {
			throw new CampoObrigatorioException("O campo senha e obrigatorio!");
		}
		
		if(senha.length() < 6) {
			throw new CampoInvalidoException("O senha esta invalido!");
		}
		
		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario(String id, String nome, String urlImagem) {
		if(id == null) {
			throw new CampoObrigatorioException("O campo identificador e obrigatorio!");
		}
		
		if(nome.length() < 5) {
			throw new CampoInvalidoException("O nome esta invalido!");
		}
		
		this.id = id;
		this.nome = nome;
		this.urlImagem = urlImagem;
	}
	
	public String getEmail() {
		return email.getEndereco();
	}

	
}
