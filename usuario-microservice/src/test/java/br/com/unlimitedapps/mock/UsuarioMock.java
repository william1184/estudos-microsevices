package br.com.unlimitedapps.mock;

import br.com.unlimitedapps.application.UsuarioAlterarForm;
import br.com.unlimitedapps.application.UsuarioIncluirForm;
import br.com.unlimitedapps.domain.FactoryUsuario;
import br.com.unlimitedapps.domain.Usuario;

public class UsuarioMock {

	public static final String SENHA_PEQUENA_DEMAIS = "123";
	public static final String NOME_PEQUENO_DEMAIS = "as";
	public static final String VAZIO = "";
	public static final String SENHA_VALIDA = "123456fr";
	public static final String NOME_VALIDO = "Joao Eduardo Santos";
	public static final String NOME_VALIDO_ALTERACAO = "Joao Eduardo Silva";
	public static final String URL_VALIDA = "https://via.placeholder.com/350x350";
	
	
	public static Usuario mockUsuarioModelValidoComBR() {
		return FactoryUsuario.builder().comCPFEmailNomeSenha(		CpfMock.CPF_VALIDO_COM_MASCARA
																, 	EmailMock.EMAIL_VALIDO_EMAIL_COM_BR
																, 	NOME_VALIDO
																,	SENHA_VALIDA	).build();
	}
	
	public static Usuario mockUsuarioModelValidoSemBR() {
		return FactoryUsuario.builder().comCPFEmailNomeSenha(		CpfMock.CPF_VALIDO_COM_MASCARA
																, 	EmailMock.EMAIL_VALIDO_EMAIL_SEM_BR
																, 	NOME_VALIDO
																,	SENHA_VALIDA	).build();
	}
	
	public static Usuario mockUsuarioModelInvalidoCpfNulo() {
		return new Usuario(null, EmailMock.mockEMAILValidoComBR(), UsuarioMock.NOME_VALIDO, UsuarioMock.SENHA_VALIDA);
	}
	
	public static Usuario mockUsuarioModelInvalidoEmailNulo() {
		return new Usuario( CpfMock.mockCPFValidoComMascara(), null, UsuarioMock.NOME_VALIDO, UsuarioMock.SENHA_VALIDA);
	}
	
	public static Usuario mockUsuarioModelInvalidoNomeNulo() {
		return new Usuario( CpfMock.mockCPFValidoComMascara(), EmailMock.mockEMAILValidoComBR(), null, UsuarioMock.SENHA_VALIDA);
	}
	
	public static Usuario mockUsuarioModelInvalidoNomeVazio() {
		return new Usuario( CpfMock.mockCPFValidoComMascara(), EmailMock.mockEMAILValidoComBR(), UsuarioMock.VAZIO, UsuarioMock.SENHA_VALIDA);
	}
	
	public static Usuario mockUsuarioModelInvalidoNomePequeno() {
		return new Usuario( CpfMock.mockCPFValidoComMascara(), EmailMock.mockEMAILValidoComBR(), UsuarioMock.NOME_PEQUENO_DEMAIS, UsuarioMock.SENHA_VALIDA);
	}
	
	public static Usuario mockUsuarioModelInvalidoSenhaNula() {
		return new Usuario( CpfMock.mockCPFValidoComMascara(), EmailMock.mockEMAILValidoComBR(), UsuarioMock.NOME_VALIDO, null);
	}
	
	public static Usuario mockUsuarioModelInvalidoSenhaVazia() {
		return new Usuario( CpfMock.mockCPFValidoComMascara(), EmailMock.mockEMAILValidoComBR(), UsuarioMock.NOME_VALIDO, UsuarioMock.VAZIO);
	}
	
	public static Usuario mockUsuarioModelInvalidoSenhaPequena() {
		return new Usuario( CpfMock.mockCPFValidoComMascara(), EmailMock.mockEMAILValidoComBR(), UsuarioMock.NOME_VALIDO, UsuarioMock.SENHA_PEQUENA_DEMAIS);
	}
	
	public static UsuarioIncluirForm mockIncluirFormValido() {
		return new UsuarioIncluirForm( CpfMock.CPF_VALIDO_COM_MASCARA, EmailMock.EMAIL_VALIDO_EMAIL_COM_BR, UsuarioMock.NOME_VALIDO, UsuarioMock.SENHA_VALIDA);
	}
	
	public static UsuarioAlterarForm mockAlterarFormValido(String id) {
		return new UsuarioAlterarForm( id, UsuarioMock.NOME_VALIDO_ALTERACAO, UsuarioMock.URL_VALIDA);
	}
	
}
