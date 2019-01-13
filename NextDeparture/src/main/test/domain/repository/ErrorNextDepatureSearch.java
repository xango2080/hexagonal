package domain.repository;

import domain.model.NextDeparture;
import domain.model.exception.NextDepartureFeatureNotAvailableException;
import domain.model.search.NextDepartureSearchQuery;

import java.util.Collection;

public class ErrorNextDepatureSearch implements NextDepartureSearch {
    @Override
    public Collection<NextDeparture> retrieveNext(NextDepartureSearchQuery query) {
        throw new NextDepartureFeatureNotAvailableException();
    }
}
