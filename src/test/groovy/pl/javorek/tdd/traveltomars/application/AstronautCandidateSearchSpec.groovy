package pl.javorek.tdd.traveltomars.application

import pl.javorek.tdd.traveltomars.application.command.TravelToMarsFacadeAbility

import pl.javorek.tdd.traveltomars.application.persistence.TravelToMarsRepositoryAbility
import spock.lang.Specification

class AstronautCandidateSearchSpec extends Specification implements TravelToMarsFacadeAbility,
        TravelToMarsRepositoryAbility {

    def "When travel to mars preparation started then travel to Mars saved and got unique id."() {
        when:
        var id = loan_application_submitted()

        then:
        expect_application_for_a_loan_is_saved(id)
    }
}
