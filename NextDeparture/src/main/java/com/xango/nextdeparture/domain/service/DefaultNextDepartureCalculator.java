package com.xango.nextdeparture.domain.service;

import com.xango.nextdeparture.annotation.ddd.DomainService;
import com.xango.nextdeparture.domain.gateway.SearchNextDeparture;
import com.xango.nextdeparture.domain.model.NextDeparture;
import com.xango.nextdeparture.domain.model.exception.InvalidNextDepartureQueryException;
import com.xango.nextdeparture.domain.model.exception.NextDepartureFeatureNotAvailableException;
import com.xango.nextdeparture.domain.model.request.NextDepartureCalculatorRequest;
import com.xango.nextdeparture.domain.model.response.NextDepartureCalculatorResponse;
import com.xango.nextdeparture.domain.model.search.NextDepartureSearchQuery;

import java.time.Instant;
import java.util.Collection;
import java.util.Objects;

@DomainService
public class DefaultNextDepartureCalculator implements NextDepartureCalculator {

    private final SearchNextDeparture searchNextDeparture;

    public DefaultNextDepartureCalculator(SearchNextDeparture searchNextDeparture) {
        Objects.requireNonNull(searchNextDeparture, "searchNextDeparture can't be null");
        this.searchNextDeparture = searchNextDeparture;
    }

    @Override
    public NextDepartureCalculatorResponse computeNextDeparture(NextDepartureCalculatorRequest request) {
        validateNextDepartureCalculatorRequest(request);
        NextDepartureSearchQuery searchQuery = new NextDepartureSearchQuery(request.getStation(), request.getDepartureDate(), request.getMaxResult());
        try {
            final Collection<NextDeparture> nextDepartures = searchNextDeparture.retrieveNext(searchQuery);
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
