package movies.spring.data.neo4j;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author mh
 * @since 14.01.15
 */
@Configuration
@ComponentScan({"movies.spring.data.neo4j.*"})
//@PropertySource("classpath:helloworld.properties")
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
@EnableTransactionManagement
public class TestNeo4jConfiguration extends Neo4jConfiguration {

    @Bean
    @Override
    public Neo4jServer neo4jServer() {
        return new InProcessServer();
        //production: return new RemoteServer(environment.getRequiredProperty("url");
    }

    @Bean
    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("movies.spring.data.neo4j.domain");
    }

}
