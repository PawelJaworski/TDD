package pl.javorek.tdd.traveltomars.application.persistence;

import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMars;
import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMarsRepository;

import java.util.*;

public class TravelToMarsInMemoryRepository implements TravelToMarsRepository {
    private final Map<UUID, TravelToMars> data = new HashMap<>();

    @Override
    public TravelToMars save(TravelToMars entity) {
        data.put(entity.getId(), entity);

        return entity;
    }

    @Override
    public Optional<TravelToMars> findOneById(UUID id) {
        return data.values().stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }
}
