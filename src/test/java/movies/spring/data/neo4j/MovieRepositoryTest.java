package movies.spring.data.neo4j;

import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.repositories.MovieRepository;
import movies.spring.data.neo4j.services.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * @author mh
 * @since 14.01.15
 */
@ContextConfiguration(classes = {TestNeo4jConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Before
    public void setUp() throws Exception {
        Movie movie = new Movie("The Matrix",1999);
        Person person = new Person("Keanu Reeves");
        movie.setCast(Collections.singleton(person));
        movieRepository.save(movie);
    }

    @Test
    public void testFindMovie() throws Exception {
        Movie matrix = movieRepository.findByTitle("The Matrix");
        assertEquals("The Matrix",matrix.getTitle());
        assertEquals(1999,matrix.getReleased());
    }
}

