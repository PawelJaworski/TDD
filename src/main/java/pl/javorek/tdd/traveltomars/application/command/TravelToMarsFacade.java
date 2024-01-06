package pl.javorek.tdd.traveltomars.application.command;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMars;
import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMarsRepository;

@Service
@Transactional
@Builder
@RequiredArgsConstructor
public class TravelToMarsFacade {
    private final TravelToMarsRepository travelToMarsRepository;

    public void onAstronautAptitudeTestPassed(String astronautId) {
        findElseCreate();
    }

    private TravelToMars findElseCreate() {
        return travelToMarsRepository.findFirstByOrderByVersionDesc()
                .orElseGet(() -> travelToMarsRepository.save(TravelToMars.planTravel()));
    }
}
