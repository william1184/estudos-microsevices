package br.com.unlimitedapps.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;
import br.com.unlimitedapps.domain.exceptions.CampoObrigatorioException;

class UsuarioModelTest {

	private static final String SENHA_PEQUENA_DEMAIS = "123";
	private static final String NOME_PEQUENO_DEMAIS = "as";
	private static final String VAZIO = "";
	private static final String SENHA_VALIDA = "123456fr";
	private static final String NOME_VALIDO = "Joao Eduardo Santos";
	private static final String CPF_VALIDO = "111.111.111-11";
	private static final String EMAIL_VALIDO = "emailvalido@email.com";

	@Test
	void deveCriarUmUsuarioValido() {
		UsuarioModel usuario = FactoryUsuario.builder().comCPFEmailNomeSenha(		CPF_VALIDO
																			, 	EMAIL_VALIDO
																			, 	NOME_VALIDO
																			,	SENHA_VALIDA	).build();
		
		Assertions.assertEquals(NOME_VALIDO, usuario.getNome());
		Assertions.assertEquals(CPF_VALIDO, usuario.getCpf().getNumero());
		Assertions.assertEquals(EMAIL_VALIDO, usuario.getEmail());
		Assertions.assertEquals(SENHA_VALIDA, usuario.getSenha());
		Assertions.assertNotNull(usuario.getDataCriacao());
		Assertions.assertEquals(TipoUsuario.PADRAO, usuario.getTipo());
	}
	
	@Test
	void deveDarErroDeUsuarioInvalido() {
		final Email email = new Email(EMAIL_VALIDO);
		final Cpf cpf = new Cpf(CPF_VALIDO);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () ->  
			new UsuarioModel(null, email, NOME_VALIDO, SENHA_VALIDA)
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () -> 
			new UsuarioModel(cpf, null, NOME_VALIDO, SENHA_VALIDA)
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () -> 
			new UsuarioModel(cpf, email, null, SENHA_VALIDA)
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () -> 
			new UsuarioModel(cpf, email, VAZIO, SENHA_VALIDA)
		);
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			new UsuarioModel(cpf, email, NOME_PEQUENO_DEMAIS, SENHA_VALIDA)
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () -> 
			new UsuarioModel(cpf, email, NOME_VALIDO, VAZIO)
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () -> 
			new UsuarioModel(cpf, email, NOME_VALIDO, null)
		);
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			new UsuarioModel(cpf, email, NOME_VALIDO, SENHA_PEQUENA_DEMAIS)
		);
		
	}

}
