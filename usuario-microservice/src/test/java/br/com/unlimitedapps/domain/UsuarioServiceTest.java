package br.com.unlimitedapps.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.unlimitedapps.domain.exceptions.UsuarioJaExisteException;
import br.com.unlimitedapps.domain.exceptions.UsuarioNaoExisteException;
import br.com.unlimitedapps.mock.CpfMock;
import br.com.unlimitedapps.mock.EmailMock;
import br.com.unlimitedapps.mock.UsuarioMock;


class UsuarioServiceTest {

	private UsuarioRepository repository;
	private UsuarioService usuarioService;
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		repository = mock(UsuarioRepository.class);
		
		usuarioService = new UsuarioService(repository);
		
		usuario = UsuarioMock.mockUsuarioModelValidoComBR();
	}

	@Test
	void deveIncluirUsuario() {
		
		usuarioService.incluirUsuario(usuario);
		
		verify(repository, times(1)).buscaPorEmail(EmailMock.EMAIL_VALIDO_EMAIL_COM_BR);
		verify(repository, times(1)).buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA);
		verify(repository, times(1)).insere(usuario);
		
	}
	
	@Test
	void deveDarErroDeUsuarioEmailJaExistente() throws UsuarioJaExisteException {

		when(repository.buscaPorEmail(EmailMock.EMAIL_VALIDO_EMAIL_COM_BR)).thenReturn(Optional.of(mock(Usuario.class)));
		
		Assertions.assertThrows(UsuarioJaExisteException.class, () -> {
			usuarioService.incluirUsuario(usuario);
		});
		
		verify(repository, times(1)).buscaPorEmail(EmailMock.EMAIL_VALIDO_EMAIL_COM_BR);
		verify(repository, times(0)).buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA);
		verify(repository, times(0)).insere(usuario);
		
	}
	
	@Test
	void deveDarErroDeUsuarioCPFJaExistente() throws UsuarioJaExisteException {
		when(repository.buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA)).thenReturn(Optional.of(mock(Usuario.class)));
		
		
		Assertions.assertThrows(UsuarioJaExisteException.class, () -> {
			usuarioService.incluirUsuario(usuario);
		});
		
		verify(repository, times(1)).buscaPorEmail(EmailMock.EMAIL_VALIDO_EMAIL_COM_BR);
		verify(repository, times(1)).buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA);
		verify(repository, times(0)).insere(usuario);
		
	}
	
	@Test
	void deveAtualizarUsuario() {
		
		when(repository.buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA)).thenReturn(Optional.of(usuario));
		
		usuarioService.atualizarUsuario(usuario);
		
		verify(repository, times(1)).atualiza(usuario);
		verify(repository, times(1)).buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA);
		
	}
	
	@Test
	void deveExcluirUsuario() {
		Usuario usuarioMock = mock(Usuario.class);
		when(repository.buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA)).thenReturn(Optional.of(usuarioMock));
		
		usuarioService.deletarUsuario(CpfMock.CPF_VALIDO_SEM_MASCARA);
		
		verify(repository, times(1)).deleta(usuarioMock);
		verify(repository, times(1)).buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA);

	}

	@Test
	void devebuscarUsuarioPorEmail() {
		
		usuarioService.buscarUsuarioPorEmail(EmailMock.EMAIL_VALIDO_EMAIL_COM_BR);
		
		verify(repository, times(1)).buscaPorEmail(EmailMock.EMAIL_VALIDO_EMAIL_COM_BR);
		
	}
	
	@Test
	void devebuscarUsuarioPorCPF() {
		
		usuarioService.buscarUsuarioPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA);
		
		verify(repository, times(1)).buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA);
	}
	
	@Test
	void devebuscarTodasUsuarios() {

		usuarioService.buscarTodosUsuarios(0, 10);
		
		verify(repository, times(1)).buscaTodosUsuarios(0, 10);
	}

	
	@Test
	void deveDarErroDeUsuarioNaoExisteAoTentarAlterar() {
		
		/*
		 * ALTERACAO
		 */
		Assertions.assertThrows(UsuarioNaoExisteException.class, () -> {
			usuarioService.atualizarUsuario(usuario);
		}, "Deveria dar erro pois o usuario com esse cpf nao existe");
		
		verify(repository, times(1)).buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA);
		verify(repository, times(0)).atualiza(usuario);
	}
	
	@Test
	void deveDarErroDeUsuarioNaoExisteAoTentarExcluir() {
		
		/*
		 * DELECAO
		 */
		Assertions.assertThrows(UsuarioNaoExisteException.class, () -> {
			usuarioService.deletarUsuario(CpfMock.CPF_VALIDO_SEM_MASCARA);
		}, "Deveria dar erro pois o usuario com esse cpf nao existe");
		
		verify(repository, times(1)).buscaPorCpf(CpfMock.CPF_VALIDO_SEM_MASCARA);
		verify(repository, times(0)).deleta(usuario);
		
	}
	
}