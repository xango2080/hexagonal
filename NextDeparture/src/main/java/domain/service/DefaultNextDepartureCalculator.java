package domain.service;

import annotation.ddd.DomainService;
import domain.model.NextDeparture;
import domain.model.exception.InvalidNextDepartureQueryException;
import domain.model.exception.NextDepartureFeatureNotAvailableException;
import domain.model.request.NextDepartureCalculatorRequest;
import domain.model.response.NextDepartureCalculatorResponse;
import domain.model.search.NextDepartureSearchQuery;
import domain.repository.NextDepartureSearch;

import java.time.Instant;
import java.util.Collection;
import java.util.Objects;

@DomainService
public class DefaultNextDepartureCalculator implements NextDepartureCalculator {

    private final NextDepartureSearch nextDepartureSearch;

    public DefaultNextDepartureCalculator(NextDepartureSearch nextDepartureSearch) {
        Objects.requireNonNull(nextDepartureSearch, "nextDepartureSearch can't be null");
        this.nextDepartureSearch = nextDepartureSearch;
    }

    @Override
    public NextDepartureCalculatorResponse computeNextDeparture(NextDepartureCalculatorRequest request) {
        validateNextDepartureCalculatorRequest(request);

        NextDepartureSearchQuery searchQuery = new NextDepartureSearchQuery(request.getStation(), request.getDepartureDate(), request.getMaxResult());
        try {
            final Collection<NextDeparture> nextDepartures = nextDepartureSearch.retrieveNext(searchQuery);
            return (nextDepartures.isEmpty()) ? NextDepartureCalculatorResponse.empty(searchQuery) : new NextDepartureCalculatorResponse(nextDepartures, searchQuery);
        } catch (NextDepartureFeatureNotAvailableException e) {
            return NextDepartureCalculatorResponse.NULL;
        }
    }

    private void validateNextDepartureCalculatorRequest(NextDepartureCalculatorRequest request) {
        if (request == null) {
            throw new InvalidNextDepartureQueryException();
        }

        if (request.getStation() == null || request.getStation().isEmpty()) {
            throw new InvalidNextDepartureQueryException();
        }

        if (request.getDepartureDate().isBefore(Instant.now())) {
            throw new InvalidNextDepartureQueryException();
        }
    }

}
