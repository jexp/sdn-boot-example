package movies.spring.data.neo4j;

import org.neo4j.server.CommunityNeoServer;
import org.neo4j.server.helpers.CommunityServerBuilder;
import org.springframework.data.neo4j.server.Neo4jServer;

import java.io.IOException;

/**
 * @author mh
 * @since 14.01.15
 */
public class InProcessServer implements Neo4jServer {

    private final CommunityNeoServer neoServer;
    protected int neoPort;

    public InProcessServer()  {
        neoPort = 8484;
        try {
            neoServer = CommunityServerBuilder.server().onPort(neoPort).build();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    neoServer.stop();
                }
            });
            neoServer.start();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public String url() {
        return neoServer.baseUri().toString();
    }


}
