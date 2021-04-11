package br.com.unlimitedapps.domain;

import java.util.Optional;

public interface UsuarioRepository {
	
	<T> Optional<T> buscaPorEmail(String email);
	
	<T> Optional<T> buscaPorCpf(String cpf);
	
	<T> Optional<T> buscaTodosUsuarios(int pagina, int quantidadade);
	
	<T> Optional<T> insere(T usuario);
	
	<T> Optional<T> atualiza(T usuario);
	
	void deleta(UsuarioModel usuario);
}
