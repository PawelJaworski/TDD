package pl.javorek.tdd.traveltomars.infrastructure.jackson;

import pl.javorek.tdd.traveltomars.infrastructure.JacksonConfig;

public interface JacksonConfigAbility {
    JacksonConfig INSTANCE = new JacksonConfig();

    default JacksonConfig getJacksonConfig() {
        return INSTANCE;
    }
}