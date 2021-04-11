package br.com.unlimitedapps.application;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.unlimitedapps.domain.UsuarioModel;

public class UsuarioDto {
	
	private String email;
	private String nome;
	private String urlImagem;
	private String cpf;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataUltimaAlteracao;
	
	public UsuarioDto() {
	}
	
	public UsuarioDto(UsuarioModel usuarioEntity) {
		this.email = usuarioEntity.getEmail();
		this.nome = usuarioEntity.getNome();
		this.urlImagem = usuarioEntity.getUrlImagem();
		this.cpf = usuarioEntity.getCpf().getNumeroComMascara();
		this.dataCriacao = usuarioEntity.getDataCriacao();
		this.dataUltimaAlteracao = usuarioEntity.getDataUltimaAlteracao();
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getUrlImagem() {
		return urlImagem;
	}
	
	public String getCpf() {
		return cpf;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public LocalDateTime getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}
	
	public static Page<UsuarioDto> converter(Page<UsuarioModel> usuarios) {
		return usuarios.map(UsuarioDto::new);
	}	
	
	public static UsuarioDto converter(UsuarioModel usuario) {
		return new UsuarioDto(usuario);
	}

}
