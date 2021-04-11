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


class UsuarioServiceTest {

	private static final String SENHA_VALIDA = "123456fr";
	private static final String NOME_VALIDO = "Joao Eduardo Santos";
	private static final String CPF_VALIDO = "11111111111";
	private static final String EMAIL_VALIDO = "emailvalido@email.com";
	private UsuarioRepository repository;
	private UsuarioService usuarioService;
	private UsuarioModel usuario;
	
	@BeforeEach
	public void setUp() {
		repository = mock(UsuarioRepository.class);
		
		usuarioService = new UsuarioService(repository);
		
		usuario = FactoryUsuario.builder().comCPFEmailNomeSenha(		CPF_VALIDO
																	, 	EMAIL_VALIDO
																	, 	NOME_VALIDO
																	,	SENHA_VALIDA	).build();
	}

	@Test
	void deveIncluirUsuario() {
		
		usuarioService.incluirUsuario(usuario);
		
		verify(repository, times(1)).buscaPorEmail(EMAIL_VALIDO);
		verify(repository, times(1)).buscaPorCpf(CPF_VALIDO);
		verify(repository, times(1)).insere(usuario);
		
	}
	
	@Test
	void deveDarErroDeUsuarioEmailJaExistente() throws UsuarioJaExisteException {

		when(repository.buscaPorEmail(EMAIL_VALIDO)).thenReturn(Optional.of(mock(UsuarioModel.class)));
		
		Assertions.assertThrows(UsuarioJaExisteException.class, () -> {
			usuarioService.incluirUsuario(usuario);
		});
		
		verify(repository, times(1)).buscaPorEmail(EMAIL_VALIDO);
		verify(repository, times(0)).buscaPorCpf(CPF_VALIDO);
		verify(repository, times(0)).insere(usuario);
		
	}
	
	@Test
	void deveDarErroDeUsuarioCPFJaExistente() throws UsuarioJaExisteException {
		when(repository.buscaPorCpf(CPF_VALIDO)).thenReturn(Optional.of(mock(UsuarioModel.class)));
		
		
		Assertions.assertThrows(UsuarioJaExisteException.class, () -> {
			usuarioService.incluirUsuario(usuario);
		});
		
		verify(repository, times(1)).buscaPorEmail(EMAIL_VALIDO);
		verify(repository, times(1)).buscaPorCpf(CPF_VALIDO);
		verify(repository, times(0)).insere(usuario);
		
	}
	
	@Test
	void deveAtualizarUsuario() {
		
		when(repository.buscaPorCpf(CPF_VALIDO)).thenReturn(Optional.of(usuario));
		
		usuarioService.atualizarUsuario(usuario);
		
		verify(repository, times(1)).atualiza(usuario);
		verify(repository, times(1)).buscaPorCpf(CPF_VALIDO);
		
	}
	
	@Test
	void deveExcluirUsuario() {
		UsuarioModel usuarioMock = mock(UsuarioModel.class);
		when(repository.buscaPorCpf(CPF_VALIDO)).thenReturn(Optional.of(usuarioMock));
		
		usuarioService.deletarUsuario(CPF_VALIDO);
		
		verify(repository, times(1)).deleta(usuarioMock);
		verify(repository, times(1)).buscaPorCpf(CPF_VALIDO);

	}

	@Test
	void devebuscarUsuarioPorEmail() {
		
		usuarioService.buscarUsuarioPorEmail(EMAIL_VALIDO);
		
		verify(repository, times(1)).buscaPorEmail(EMAIL_VALIDO);
		
	}
	
	@Test
	void devebuscarUsuarioPorCPF() {
		
		usuarioService.buscarUsuarioPorCpf(CPF_VALIDO);
		
		verify(repository, times(1)).buscaPorCpf(CPF_VALIDO);
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
		
		verify(repository, times(1)).buscaPorCpf(CPF_VALIDO);
		verify(repository, times(0)).atualiza(usuario);
	}
	
	@Test
	void deveDarErroDeUsuarioNaoExisteAoTentarExcluir() {
		
		/*
		 * DELECAO
		 */
		Assertions.assertThrows(UsuarioNaoExisteException.class, () -> {
			usuarioService.deletarUsuario(CPF_VALIDO);
		}, "Deveria dar erro pois o usuario com esse cpf nao existe");
		
		verify(repository, times(1)).buscaPorCpf(CPF_VALIDO);
		verify(repository, times(0)).deleta(usuario);
		
	}
	
}