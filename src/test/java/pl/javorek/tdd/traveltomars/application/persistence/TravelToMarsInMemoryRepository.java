package pl.javorek.tdd.traveltomars.application.persistence;

import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMars;
import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMarsRepository;

import java.util.*;

public class TravelToMarsInMemoryRepository implements TravelToMarsRepository {
    private final Map<Integer, TravelToMars> data = new HashMap<>();

    @Override
    public TravelToMars save(TravelToMars entity) {
        data.put(entity.getVersion(), entity);

        return entity;
    }

    @Override
    public Optional<TravelToMars> findFirstByOrderByVersionDesc() {
        return  data.values().stream()
                .findFirst();
    }
}
