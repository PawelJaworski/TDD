package pl.javorek.tdd.traveltomars.application.command.persistence;

import java.util.Optional;

public interface TravelToMarsRepository {

    TravelToMars save(TravelToMars state);

    Optional<TravelToMars> findFirstByOrderByVersionDesc();
}
