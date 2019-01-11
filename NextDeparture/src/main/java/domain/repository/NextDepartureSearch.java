package domain.repository;

import domain.model.NextDeparture;
import domain.model.NextDepartureSearchQuery;

import java.util.Collection;

public interface NextDepartureSearch {

	Collection<NextDeparture> retrieveNext(NextDepartureSearchQuery query);
}
