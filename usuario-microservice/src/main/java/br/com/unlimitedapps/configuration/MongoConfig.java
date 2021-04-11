package br.com.unlimitedapps.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
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

}
