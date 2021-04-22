package br.com.unlimitedapps.domain;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
	
	Optional<Usuario> buscaPorIndentificador(String id);
	
	Optional<Usuario> buscaPorEmail(String email);
	
	Optional<Usuario> buscaPorCpf(String cpf);
	
	Optional<List<Usuario>> buscaTodosUsuarios(int pagina, int quantidadade);
	
	Optional<Usuario> insere(Usuario usuario);
	
	Optional<Usuario> atualiza(Usuario usuario);
	
	void deleta(Usuario usuario);
}
