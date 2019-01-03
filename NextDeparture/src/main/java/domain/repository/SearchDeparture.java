package domain.repository;

import java.util.Collection;

import domain.model.NextDeparture;

public interface SearchDeparture {

	Collection<NextDeparture> retrieveNext(String station);
}
