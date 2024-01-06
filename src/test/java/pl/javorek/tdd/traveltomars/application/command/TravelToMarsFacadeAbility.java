package pl.javorek.tdd.traveltomars.application.command;

import pl.javorek.tdd.traveltomars.application.persistence.TravelToMarsRepositoryAbility;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Consumer;

public interface TravelToMarsFacadeAbility {
    String ASTRONAUT_ID = "test-astronaut";
    TravelToMarsFacade INSTANCE = TravelToMarsFacade.builder()
            .travelToMarsRepository(TravelToMarsRepositoryAbility.INSTANCE)
            .build();

    default UUID loan_application_submitted() {
        return getApplicationForALoanCmdFacade().onAstronautAptitudeTest(ASTRONAUT_ID);
    }

    default TravelToMarsFacade getApplicationForALoanCmdFacade() {
        return INSTANCE;
    }
}
