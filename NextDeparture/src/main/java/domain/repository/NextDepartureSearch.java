package domain.repository;

import domain.model.NextDeparture;
import domain.model.search.NextDepartureSearchQuery;

import java.util.Collection;

public interface NextDepartureSearch {

	Collection<NextDeparture> retrieveNext(NextDepartureSearchQuery query);
}
