package domain.service;

import domain.model.NextDeparture;

import java.time.Instant;
import java.util.Collection;

public interface NextDepartureService {
    Collection<NextDeparture> findByStationAndDepartureTime(String stationu, Instant departureDate);
}
