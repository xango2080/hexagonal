package domain.repository;

import java.time.Instant;
import java.util.Collection;

import domain.model.NextDeparture;

public interface NextDepartureRepository {

	Collection<NextDeparture> retrieveNext(String station, Instant departureTime, long maxResults);
}
