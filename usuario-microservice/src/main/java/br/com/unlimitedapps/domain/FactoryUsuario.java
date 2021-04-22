package br.com.unlimitedapps.domain;

public class FactoryUsuario {
	private Usuario usuario;
	
	public static FactoryUsuario builder() {
		return new FactoryUsuario();
	}
	
	public FactoryUsuario comCPFEmailNomeSenha(String cpf, String email, String nome, String senha) {
		usuario = new Usuario(new Cpf(cpf), new Email(email), nome, senha);
		return this;
	}
	
	public FactoryUsuario comIdNomeUrlImagem(String id, String nome, String urlImagem) {
		usuario = new Usuario(id, nome, urlImagem);
		return this;
	}
	
	public Usuario build() {
		return usuario;
	}

	
}
