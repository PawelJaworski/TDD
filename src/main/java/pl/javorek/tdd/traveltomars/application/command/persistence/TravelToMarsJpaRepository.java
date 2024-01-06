package pl.javorek.tdd.traveltomars.application.command.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface TravelToMarsJpaRepository extends TravelToMarsRepository, JpaRepository<TravelToMars, UUID> {

}
