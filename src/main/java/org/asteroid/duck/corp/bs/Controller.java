package org.asteroid.duck.corp.bs;

import org.apache.tomcat.util.http.MimeHeaders;
import org.asteroid.duck.corp.bs.input.WordSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/")
public class Controller {
    private final Map<WordType, WordSource> sources;

    @Autowired
    public Controller(Map<WordType, WordSource> sources) {
        this.sources = sources;
    }

    @RequestMapping(value = "bs",produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String generateBS() {
        return WordType.inOrder().map(type -> sources.get(type)).map(WordSource::getNewWord).collect(Collectors.joining(" "));
    }

}
