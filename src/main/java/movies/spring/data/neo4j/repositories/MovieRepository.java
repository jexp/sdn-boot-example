package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author mh
 * @since 24.07.12
 */
//@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")

// tag::repository[]
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends GraphRepository<Movie> {
    @Query("MATCH (m:Movie {title:'The Matrix'}) RETURN m")
    Movie findByTitle(String title);

//    @Query("MATCH (m:Movie) WHERE title =~ '(?i).*'+{title}+'.*' RETURN m")
    @Query("MATCH (m:Movie) WHERE title =~ '(?i).*Matrix.*' RETURN m")
    Collection<Movie> findByTitleContaining(@Param("0") String title);

    @Query("MATCH (m:Movie)<-[:ACTED_IN]-(a:Person) RETURN m.title as movie, collect(a.name) as cast")
    List<Map<String, Object>> graph();
}
// end::repository[]

