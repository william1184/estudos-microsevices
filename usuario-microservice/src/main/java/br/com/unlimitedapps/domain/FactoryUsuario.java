package br.com.unlimitedapps.domain;

public class FactoryUsuario {
	private UsuarioModel usuario;
	
	public static FactoryUsuario builder() {
		return new FactoryUsuario();
	}
	
	public FactoryUsuario comCPFEmailNomeSenha(String cpf, String email, String nome, String senha) {
		usuario = new UsuarioModel(new Cpf(cpf), new Email(email), nome, senha);
		return this;
	}
	
	public UsuarioModel build() {
		return usuario;
	}

	public FactoryUsuario comCPFEmailNomeSenha(String cpf, String nome, String urlImagem) {
		usuario = new UsuarioModel(new Cpf(cpf), nome, urlImagem);
		return null;
	}
	
}
