package pl.javorek.tdd.traveltomars.eventstream.inbound;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.javorek.tdd.traveltomars.application.command.TravelToMarsFacade;
import pl.javorek.tdd.traveltomars.eventstream.inbound.contract.AstronautAptitudeTestPassedEvent;

@Component
@RequiredArgsConstructor
class AstronautCandidateEventListener {
    private TravelToMarsFacade applicationForALoanCmdFacade;

    public void onLoanStarted(AstronautAptitudeTestPassedEvent event) {
//        Optional.ofNullable(event)
//                .map(LoanStartedEvent::applicationNumber)
//                .map(SendCommunicationAboutStartedLoanCmd::new)
//                .ifPresent(applicationForALoanCmdFacade::sendCommunicationAboutStartedLoan);
    }
}
