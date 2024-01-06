package pl.javorek.tdd.traveltomars.application.command.persistence;

import java.util.Optional;
import java.util.UUID;

public interface TravelToMarsRepository {

    TravelToMars save(TravelToMars state);

    Optional<TravelToMars> findOneById(UUID id);
}
