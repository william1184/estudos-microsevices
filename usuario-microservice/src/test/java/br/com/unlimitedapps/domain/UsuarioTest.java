package br.com.unlimitedapps.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.CampoInvalidoException;
import br.com.unlimitedapps.domain.exceptions.CampoObrigatorioException;
import br.com.unlimitedapps.mock.CpfMock;
import br.com.unlimitedapps.mock.EmailMock;
import br.com.unlimitedapps.mock.UsuarioMock;

class UsuarioTest {

	@Test
	void deveCriarUmUsuarioValido() {
		Usuario usuario = UsuarioMock.mockUsuarioModelValidoComBR();
		
		Assertions.assertEquals(UsuarioMock.NOME_VALIDO, usuario.getNome());
		Assertions.assertEquals(CpfMock.CPF_VALIDO_SEM_MASCARA, usuario.getCpf().getNumero());
		Assertions.assertEquals(CpfMock.CPF_VALIDO_COM_MASCARA, usuario.getCpf().getNumeroComMascara());
		Assertions.assertEquals(EmailMock.EMAIL_VALIDO_EMAIL_COM_BR, usuario.getEmail());
		Assertions.assertEquals(UsuarioMock.SENHA_VALIDA, usuario.getSenha());
		Assertions.assertNotNull(usuario.getDataCriacao());
		Assertions.assertEquals(TipoUsuario.PADRAO, usuario.getTipo());
	}
	
	@Test
	void deveDarErroDeUsuarioInvalido() {
		
		Assertions.assertThrows(CampoObrigatorioException.class, () ->  
			UsuarioMock.mockUsuarioModelInvalidoCpfNulo()
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () -> 
			UsuarioMock.mockUsuarioModelInvalidoEmailNulo()
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () -> 
			UsuarioMock.mockUsuarioModelInvalidoNomeNulo()
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () ->
		UsuarioMock.mockUsuarioModelInvalidoNomeVazio()
		);
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			UsuarioMock.mockUsuarioModelInvalidoNomePequeno()
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () -> 
			UsuarioMock.mockUsuarioModelInvalidoSenhaVazia()
		);
		
		Assertions.assertThrows(CampoObrigatorioException.class, () -> 
			UsuarioMock.mockUsuarioModelInvalidoSenhaNula()
		);
		
		Assertions.assertThrows(CampoInvalidoException.class, () -> 
			UsuarioMock.mockUsuarioModelInvalidoSenhaPequena()
		);
		
	}

}
