package com.rarebook.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${mongo.db.username}")
    private static String username;

    @Value("${mongo.db.password}")
    private static String password;

    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/test");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

}