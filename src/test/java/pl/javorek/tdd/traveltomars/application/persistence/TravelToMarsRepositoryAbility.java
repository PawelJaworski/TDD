package pl.javorek.tdd.traveltomars.application.persistence;

import org.junit.jupiter.api.Assertions;
import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMarsRepository;

import java.util.UUID;

public interface TravelToMarsRepositoryAbility {
    TravelToMarsRepository INSTANCE = new TravelToMarsInMemoryRepository();

    default void expect_application_for_a_loan_is_saved(UUID id) {
      var found = getApplicationForALoanEntityRepository().findOneById(id);

      Assertions.assertTrue(found.isPresent(), "Travel to Mars with id " + id + " not found.");
    }

    default TravelToMarsRepository getApplicationForALoanEntityRepository() {
        return INSTANCE;
    }
}
