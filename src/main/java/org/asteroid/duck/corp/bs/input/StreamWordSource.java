package org.asteroid.duck.corp.bs.input;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@AllArgsConstructor
public class StreamWordSource implements WordSource {
    private final List<String> words;
    private final Random random = new Random();
    
    public static final StreamWordSource wrapInputStream(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
        List<String> words = reader.lines().collect(Collectors.toList());
        return new StreamWordSource(Collections.unmodifiableList(words));
    }

    @Override
    public String getNewWord() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
