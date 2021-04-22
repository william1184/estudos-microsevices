
package br.com.unlimitedapps.infra;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import br.com.unlimitedapps.domain.Usuario;
import br.com.unlimitedapps.domain.UsuarioRepository;


@Repository
public class UsuarioMongoDbRepository implements UsuarioRepository {
	
	private MongoTemplate mongo;
	
	public UsuarioMongoDbRepository() {
	}
	
	@Autowired
	public UsuarioMongoDbRepository(MongoTemplate mongo) {
		this.mongo = mongo;
	}

	@Override
	public Optional<Usuario> buscaPorEmail(String email) {
		return Optional.ofNullable( mongo.findOne(Query.query(Criteria.where("email.endereco").is(email)), Usuario.class) );
	}

	@Override
	public Optional<Usuario> buscaPorCpf(String cpf) {
		return Optional.ofNullable( mongo.findOne(Query.query(Criteria.where("cpf.numero").is(cpf)), Usuario.class) );
	}

	@Override
	public Optional<List<Usuario>> buscaTodosUsuarios(int pagina, int quantidade) {
		return Optional.ofNullable( Collections.emptyList() );
//		PageRequest pageable = PageRequest.of( pagina, quantidade);
//		
//		Query q = new Query(new Criteria().alike((Example<?>) new Usuario())).with(pageable);
//		List<S> list = mongo.find(q, example.getProbeType(), entityInformation.getCollectionName());
//
//		return PageableExecutionUtils.getPage(list, pageable,
//				() -> mongoOperations.count(q, example.getProbeType(), entityInformation.getCollectionName()));
	}
	
	@Override
	public void deleta(Usuario usuario) {
		mongo.remove(usuario);
	}

	@Override
	public Optional<Usuario> insere(Usuario usuario) {
		return Optional.ofNullable( mongo.insert(usuario) );
	}

	@Override
	public Optional<Usuario> atualiza(Usuario usuario) {
		return Optional.ofNullable( mongo.save(usuario) );
	}

	@Override
	public Optional<Usuario> buscaPorIndentificador(String id) {
		return Optional.ofNullable( mongo.findOne(Query.query(Criteria.where("_id").is(id)), Usuario.class) );
	}

	
}
