package com.xango.nextdeparture.domain.gateway;

import com.xango.nextdeparture.domain.model.NextDeparture;
import com.xango.nextdeparture.domain.model.exception.NextDepartureFeatureNotAvailableException;
import com.xango.nextdeparture.domain.model.search.NextDepartureSearchQuery;

import java.util.Collection;

public class ErrorNextDepatureSearch implements NextDepartureSearch {
    @Override
    public Collection<NextDeparture> retrieveNext(NextDepartureSearchQuery query) {
        throw new NextDepartureFeatureNotAvailableException();
    }
}
