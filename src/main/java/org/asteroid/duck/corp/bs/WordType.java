package org.asteroid.duck.corp.bs;

import java.util.stream.Stream;

public enum WordType {
    ADVERB, VERB, ADJECTIVE, NOUN;

    public static final Stream<WordType> inOrder() {
        return Stream.of( ADVERB, VERB, ADJECTIVE, NOUN);
    }
}
