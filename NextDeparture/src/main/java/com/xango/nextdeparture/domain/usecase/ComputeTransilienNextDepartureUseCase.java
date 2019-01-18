package com.xango.nextdeparture.domain.usecase;

import com.xango.nextdeparture.annotation.clean.UseCase;
import com.xango.nextdeparture.domain.model.NextDeparture;
import com.xango.nextdeparture.domain.model.exception.NextDepartureFeatureNotAvailableException;
import com.xango.nextdeparture.domain.model.request.NextDepartureCalculatorRequest;
import com.xango.nextdeparture.domain.model.response.NextDepartureCalculatorResponse;
import com.xango.nextdeparture.domain.model.search.NextDepartureSearchQuery;
import com.xango.nextdeparture.domain.gateway.SearchNextDeparture;
import com.xango.nextdeparture.domain.service.NextDepartureCalculator;

import java.util.Collection;
import java.util.Objects;

@UseCase
public class ComputeTransilienNextDepartureUseCase implements NextDepartureCalculator {

    private final SearchNextDeparture searchNextDeparture;
    private final NextDepartureCalculatorRequestValidator validator;

    public ComputeTransilienNextDepartureUseCase(SearchNextDeparture searchNextDeparture, NextDepartureCalculatorRequestValidator validator) {
        Objects.requireNonNull(searchNextDeparture, "searchNextDeparture can't be null");
        this.searchNextDeparture = searchNextDeparture;
        this.validator = validator;
    }

    @Override
    public NextDepartureCalculatorResponse computeNextDeparture(NextDepartureCalculatorRequest request) {
        validator.validateNextDepartureCalculatorRequest(request);
        NextDepartureSearchQuery searchQuery = new NextDepartureSearchQuery(request.getStation(), request.getDepartureDate(), request.getMaxResult());
        try {
            final Collection<NextDeparture> nextDepartures = searchNextDeparture.retrieveNext(searchQuery);
            return (nextDepartures.isEmpty()) ? NextDepartureCalculatorResponse.empty(searchQuery) : new NextDepartureCalculatorResponse(nextDepartures, searchQuery);
        } catch (NextDepartureFeatureNotAvailableException e) {
            return NextDepartureCalculatorResponse.NULL;
        }
    }


}
