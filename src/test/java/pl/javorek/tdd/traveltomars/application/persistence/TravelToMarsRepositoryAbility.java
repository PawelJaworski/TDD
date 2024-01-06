package pl.javorek.tdd.traveltomars.application.persistence;

import org.junit.jupiter.api.Assertions;
import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMarsRepository;

public interface TravelToMarsRepositoryAbility {
    TravelToMarsRepository INSTANCE = new TravelToMarsInMemoryRepository();

    default void expect_application_for_a_loan_is_saved() {
      var found = getApplicationForALoanEntityRepository().findFirstByOrderByVersionDesc();

      Assertions.assertTrue(found.isPresent(), "Travel to Mars with not found.");
    }

    default TravelToMarsRepository getApplicationForALoanEntityRepository() {
        return INSTANCE;
    }
}
