package pl.javorek.tdd.traveltomars.application.command;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMars;
import pl.javorek.tdd.traveltomars.application.command.persistence.TravelToMarsRepository;

import java.util.UUID;

@Service
@Transactional
@Builder
@RequiredArgsConstructor
public class TravelToMarsFacade {
    private final TravelToMarsRepository travelToMarsRepository;

    public UUID onAstronautAptitudeTest(String astronautId) {
        return travelToMarsRepository
                .save(new TravelToMars())
                .getId();
    }


}
