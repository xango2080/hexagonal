package domain.service;

import domain.model.NextDeparture;

import java.util.Collection;

public interface NextDepartureCalculator {
    Collection<NextDeparture> computeNextDepartureFrom(String station);
}
