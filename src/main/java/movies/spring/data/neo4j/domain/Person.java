package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.annotation.*;

import java.util.Collection;

//@NodeEntity
public class Person {
//    @GraphId
    Long id;

//    @Indexed
    private String name;
    private int born;

    @Relationship(type = Movie.ACTED_IN)
    Collection<Movie> movies;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public int getBorn() {
        return born;
    }

    public Collection<Movie> getMovies() {
        return movies;
    }
}
