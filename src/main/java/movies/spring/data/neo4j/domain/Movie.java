package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// tag::movie[]
public class Movie {

    final static String ACTED_IN = "ACTED_IN";

    Long id;

    String title;

    int released;
    String tagline;

    @Relationship(type=ACTED_IN, direction = Relationship.INCOMING) Collection<Person> cast;

// end::movie[]


    public Movie() {
    }

    public Movie(String title, int released) {
        this.title = title;
        this.released = released;
    }

    public String getTitle() {
        return title;
    }

    public int getReleased() {
        return released;
    }

    public String getTagline() {
        return tagline;
    }

    public Collection<Person> getCast() {
        return cast;
    }

    public void setCast(Collection<Person> cast) {
        this.cast = cast;
    }
}
