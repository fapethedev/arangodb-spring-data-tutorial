package com.fapethedev.arangodb.sdt;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories(basePackages = "com.fapethedev.arangodb.sdt")
public class SdtConfiguration implements ArangoConfiguration
{
    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder()
                .host("localhost", 8529)
                .user("root")
                .password("tbDmKOCz0UaTU3LL"); // use your arangodb instance password or null
    }

    @Override
    public String database() {
        return "spring-data-tutorial";
    }
}
