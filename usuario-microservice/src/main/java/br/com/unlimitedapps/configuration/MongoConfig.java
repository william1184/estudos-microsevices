package br.com.unlimitedapps.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.unlimitedapps.infra")
public class MongoConfig extends AbstractMongoClientConfiguration {
	@Value( "${spring.data.mongodb.database}" )
	private String dbName;
	
	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public boolean autoIndexCreation() {
		return false;
	}
	
	@Bean
	@Override
	public MongoClient mongoClient() {
		return MongoClients.create();
	}
	
	@Bean
	@Override
	public MongoDatabaseFactory mongoDbFactory() {
		return new SimpleMongoClientDatabaseFactory(mongoClient(), getDatabaseName());
	}
	
	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoDbFactory());
	}

}

