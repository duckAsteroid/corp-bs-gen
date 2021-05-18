package org.asteroid.duck.corp.bs;

import org.asteroid.duck.corp.bs.input.WordSource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/rest/")
public class Controller {
    private final Map<WordType, WordSource> sources;

    @Inject
    public Controller(Map<WordType, WordSource> sources) {
        this.sources = sources;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value = "bs")
    public String generateBS() {
        return WordType.inOrder().map(type -> sources.get(type)).map(WordSource::getNewWord).collect(Collectors.joining(" "));
    }

}
