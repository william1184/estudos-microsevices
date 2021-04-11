package br.com.unlimitedapps.infra;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import br.com.unlimitedapps.domain.UsuarioModel;
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
	public Optional<UsuarioModel> buscaPorEmail(String email) {
		return Optional.of( mongo.findOne(Query.query(Criteria.where("email").is(email)), UsuarioModel.class) );
	}

	@Override
	public Optional<UsuarioModel> buscaPorCpf(String cpf) {
		return Optional.of( mongo.findOne(Query.query(Criteria.where("cpf").is(cpf)), UsuarioModel.class) );
	}

	@Override
	public Optional<List<UsuarioModel>> buscaTodosUsuarios(int pagina, int quantidade) {
		return Optional.of( Collections.emptyList() );
//		PageRequest pageable = PageRequest.of( pagina, quantidade);
//		
//		Query q = new Query(new Criteria().alike((Example<?>) new Usuario())).with(pageable);
//		List<S> list = mongo.find(q, example.getProbeType(), entityInformation.getCollectionName());
//
//		return PageableExecutionUtils.getPage(list, pageable,
//				() -> mongoOperations.count(q, example.getProbeType(), entityInformation.getCollectionName()));
	}
	
	@Override
	public void deleta(UsuarioModel usuario) {
		mongo.remove(usuario);
	}

	@Override
	public <T> Optional<T> insere(T usuario) {
		return Optional.of( mongo.insert(usuario) );
	}

	@Override
	public <T> Optional<T> atualiza(T usuario) {
		return Optional.of( mongo.save(usuario) );
	}

	
}
