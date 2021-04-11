package br.com.unlimitedapps.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.unlimitedapps.domain.UsuarioService;
import br.com.unlimitedapps.infra.UsuarioMongoDbRepository;

@Configuration
public class UsuarioConfig {

    @Bean
    public UsuarioMongoDbRepository createRepository() {
        return new UsuarioMongoDbRepository();
    }
    @Bean
    public UsuarioService createCategoryRestConverter() {
        return new UsuarioService(createRepository());
    }
}