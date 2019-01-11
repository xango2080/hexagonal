package domain.service;

import domain.model.*;
import domain.repository.NextDepartureSearch;

import java.time.Instant;
import java.util.Collection;
import java.util.Objects;

public class DefaultNextDepartureCalculator implements NextDepartureCalculator {

    private final NextDepartureSearch nextDepartureSearch;

    public DefaultNextDepartureCalculator(NextDepartureSearch nextDepartureSearch) {
        Objects.requireNonNull(nextDepartureSearch, "nextDepartureSearch can't be null");
        this.nextDepartureSearch = nextDepartureSearch;
    }

    @Override
    public NextDepartureCalculatorResponse computeNextDeparture(NextDepartureCalculatorRequest request) {
        NextDepartureSearchQuery searchQuery = new NextDepartureSearchQuery(request.getStation(), request.getDepartureDate(), request.getMaxResult());
        try {
            final Collection<NextDeparture> nextDepartures = nextDepartureSearch.retrieveNext(searchQuery);
            return new NextDepartureCalculatorResponse(nextDepartures, searchQuery);
        } catch (NextDepartureFeatureNotAvailableException e) {
            return NextDepartureCalculatorResponse.empty(searchQuery);
        }
    }

}
