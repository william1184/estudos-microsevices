package br.com.unlimitedapps.application;

import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

import br.com.unlimitedapps.domain.Usuario;
import lombok.Getter;

@Getter
public class UsuarioDto {
	
	private String id;
	private String email;
	private String nome;
	private String urlImagem;
	private String cpf;
	private long dataCriacao;
	private long dataUltimaAlteracao;
	
	public UsuarioDto() {
	}
	
	public UsuarioDto(Usuario usuarioEntity) {
		this.id = usuarioEntity.getId();
		this.email = usuarioEntity.getEmail();
		this.nome = usuarioEntity.getNome();
		this.urlImagem = usuarioEntity.getUrlImagem();
		this.cpf = usuarioEntity.getCpf().getNumeroComMascara();
		this.dataCriacao = usuarioEntity.getDataCriacao().toInstant(ZoneOffset.UTC).toEpochMilli();
		this.dataUltimaAlteracao = usuarioEntity.getDataUltimaAlteracao().toInstant(ZoneOffset.UTC).toEpochMilli();
	}
	
	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map( UsuarioDto::new ).collect(Collectors.toList());
	}	
	
	public static UsuarioDto converter(Usuario usuario) {
		return new UsuarioDto(usuario);
	}

}
