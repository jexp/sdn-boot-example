package movies.spring.data.neo4j;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// tag::config[]
@Configuration
@ComponentScan({"movies.spring.data.neo4j.*"})
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
@EnableTransactionManagement
public class MyNeo4jConfiguration extends Neo4jConfiguration {

    @Autowired
    Environment environment;

    @Bean
    @Override
    public Neo4jServer neo4jServer() {
        return new RemoteServer(environment.getRequiredProperty("url"));
    }

    @Bean
    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("movies.spring.data.neo4j.domain");
    }
}
// end::config[]
