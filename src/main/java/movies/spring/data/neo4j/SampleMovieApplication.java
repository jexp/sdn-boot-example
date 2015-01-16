package movies.spring.data.neo4j;

import movies.spring.data.neo4j.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @author mh
 * @since 06.10.14
 */
@Configuration
@Import(MyNeo4jConfiguration.class)
@RestController("/")
@SpringBootApplication
public class SampleMovieApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SampleMovieApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SampleMovieApplication.class);
    }

    @Autowired
    MovieService movieService;

    @RequestMapping("/graph")
    public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
//        return movieService.graph(limit == null ? 100 : limit);
        return Collections.emptyMap();
    }

}
