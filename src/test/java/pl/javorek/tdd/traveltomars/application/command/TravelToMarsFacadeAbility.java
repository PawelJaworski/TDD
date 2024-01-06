package pl.javorek.tdd.traveltomars.application.command;

import pl.javorek.tdd.traveltomars.application.persistence.TravelToMarsRepositoryAbility;

import static pl.javorek.tdd.traveltomars.test.TestDataProviderAbility.ASTRONAUT_ID;
import static pl.javorek.tdd.traveltomars.test.TestDataProviderAbility.TRAVEL_TO_MARS_ID;

public interface TravelToMarsFacadeAbility {

    TravelToMarsFacade INSTANCE = TravelToMarsFacade.builder()
            .travelToMarsRepository(TravelToMarsRepositoryAbility.INSTANCE)
            .build();

    default void loan_application_submitted() {
        getApplicationForALoanCmdFacade().onAstronautAptitudeTestPassed(ASTRONAUT_ID);
    }

    default TravelToMarsFacade getApplicationForALoanCmdFacade() {
        return INSTANCE;
    }
}
