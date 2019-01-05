package domain.service;

import domain.model.NextDeparture;
import domain.model.NextDepartureFeatureNotAvailableException;
import domain.repository.NextDepartureRepository;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class DefaultNextDepartureService implements NextDepartureService {

	private final NextDepartureRepository nextDepartureRepository;
	private final long maxResults;

	public DefaultNextDepartureService(NextDepartureRepository nextDepartureRepository, long maxResults) {
		Objects.requireNonNull(nextDepartureRepository, "nextDepartureRepository can't be null");
		this.nextDepartureRepository = nextDepartureRepository;
		this.maxResults = maxResults;
	}

	@Override
	public Collection<NextDeparture> findByStationAndDepartureTime(String station, Instant departureDate){
		checkStation(station);
		checkDate(departureDate);
		try {
			return nextDepartureRepository.retrieveNext(station, departureDate, maxResults);
		} catch (NextDepartureFeatureNotAvailableException e){
			return Collections.emptyList();
		}
	}

	private void checkDate(Instant departureDate) {
		if(departureDate == null || departureDate.isBefore(Instant.now())){
			throw new IllegalArgumentException("Date is invalid");
		}
	}

	private void checkStation(String station) {
		if(station == null) {
			throw new IllegalArgumentException("Station name is invalid");
		}
	}

}
