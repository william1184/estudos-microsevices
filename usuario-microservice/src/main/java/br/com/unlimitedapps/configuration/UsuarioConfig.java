package br.com.unlimitedapps.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.unlimitedapps.domain.UsuarioService;
import br.com.unlimitedapps.infra.UsuarioMongoDbRepository;

@Configuration
public class UsuarioConfig {

	@Autowired
	private MongoTemplate mongoTemplate;
	
    @Bean
    public UsuarioMongoDbRepository createRepository() {
        return new UsuarioMongoDbRepository(mongoTemplate);
    }
    
    @Bean
    public UsuarioService createService() {
        return new UsuarioService(createRepository());
    }
    
}