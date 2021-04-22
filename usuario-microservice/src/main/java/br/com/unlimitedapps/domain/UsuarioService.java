package br.com.unlimitedapps.domain;



import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.unlimitedapps.common.CommonUtils;
import br.com.unlimitedapps.domain.exceptions.CampoObrigatorioException;
import br.com.unlimitedapps.domain.exceptions.UsuarioJaExisteException;
import br.com.unlimitedapps.domain.exceptions.UsuarioNaoExisteException;


public class UsuarioService {
	
	private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
	
	/**
	 * @param ProdutoEntity
	 * @return Optional<Usuario>
	 */
	public Optional<Usuario> incluirUsuario(Usuario usuario) {
		verificaSeUsuarioJaExiste(usuario);
			
		if( usuario.getEmail() == null || CommonUtils.isTextoNuloOuVazio(usuario.getNome()) || 
				CommonUtils.isTextoNuloOuVazio(usuario.getSenha()) || usuario.getCpf() == null	) {
			throw new CampoObrigatorioException("Nome, email, cpf e senha");
		}
		
		usuario.setSenha( new BCryptPasswordEncoder().encode( usuario.getSenha() ) );
		
		return repository.insere(usuario);			
		
	}

	private void verificaSeUsuarioJaExiste(Usuario usuario) {
		Optional<Usuario> usuarioBD = buscarUsuarioPorEmail(usuario.getEmail());
		
		if(usuarioBD.isPresent()) {
			throw new UsuarioJaExisteException("Ja existe com o email " + usuario.getEmail());			
		}
		
		usuarioBD = buscarUsuarioPorCpf(usuario.getCpf());
			
		if(usuarioBD.isPresent()) {
			throw new UsuarioJaExisteException("Ja existe com o cpf " + usuario.getCpf().getNumero());			
		}
	}
	
	
	/**
	 * 
	 * @param ProdutoEntity
	 * @return Optional<Usuario>
	 */
	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
		
		if(usuario.getId() == null || CommonUtils.isTextoNuloOuVazio(usuario.getNome())) {
			throw new CampoObrigatorioException("id e nome");
		}
		
		Optional<Usuario> usuarioBD = buscarUsuarioPorIndentificador(usuario.getId());
		
		if(!usuarioBD.isPresent()) {
			throw new UsuarioNaoExisteException("Nao existe com o id " + usuario.getId());
		}
		
		Usuario usuarioAtualizado = usuarioBD.get();
		
		usuarioAtualizado.setNome(usuario.getNome());
		usuarioAtualizado.setUrlImagem(usuario.getUrlImagem());
		
		return repository.atualiza(usuarioAtualizado);			
		
	}
	
	/**
	 * 
	 * @param String
	 */
	public void deletarUsuario(String id) {
		
		Optional<Usuario> usuarioBD = buscarUsuarioPorIndentificador(id);
		
		if(usuarioBD.isPresent()) {
			repository.deleta(usuarioBD.get());		
			return;
		}
		
		throw new UsuarioNaoExisteException("Nao existe com o id" + id);
		
	}
	
	/**
	 * 
	 * @param Email Email
	 * @return Optional<Usuario>
	 */
	public Optional<Usuario> buscarUsuarioPorEmail(String enderecoEmail) {
		return buscarUsuarioPorEmail(new Email(enderecoEmail));
	}
	
	/**
	 * 
	 * @param String
	 * @return Optional<Usuario>
	 */
	public Optional<Usuario> buscarUsuarioPorIndentificador(String id) {
		
		if( id == null ) {
			throw new CampoObrigatorioException("Indentificador");
		}
		
		return repository.buscaPorIndentificador(id);
		
	}
	
	/**
	 * 
	 * @param String
	 * @return Optional<Usuario>
	 */
	public Optional<Usuario> buscarUsuarioPorEmail(Email email) {
		
		if( email == null ) {
			throw new CampoObrigatorioException("Email");
		}
		
		return repository.buscaPorEmail(email.getEndereco());
		
	}
	
	/**
	 * 
	 * @param String
	 * @return Optional<Usuario>
	 */
	public Optional<Usuario> buscarUsuarioPorCpf(String numeroCpf) {
		return buscarUsuarioPorCpf( new Cpf(numeroCpf) );
	}
	/**
	 * 
	 * @param String
	 * @return Optional<Usuario>
	 */
	public Optional<Usuario> buscarUsuarioPorCpf(Cpf cpf) {
		
		if( cpf == null ) {
			throw new CampoObrigatorioException("Cpf");
		}
		
		return repository.buscaPorCpf(cpf.getNumero());
		
	}
	
	/**
	 * 
	 * @param String
	 * @param String
	 * @return Page<Usuario>
	 */
	public Optional<List<Usuario>> buscarTodosUsuarios(int pagina, int count) {
		
		if( pagina == 0 && count == 0 ) {
			throw new CampoObrigatorioException("Página e Count");
		}
		
		return this.repository.buscaTodosUsuarios( pagina, count );
	}
}
