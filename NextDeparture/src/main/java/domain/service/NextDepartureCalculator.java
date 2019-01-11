package domain.service;

import domain.model.NextDepartureCalculatorRequest;
import domain.model.NextDepartureCalculatorResponse;

import java.time.Instant;

public interface NextDepartureCalculator {
    NextDepartureCalculatorResponse computeNextDeparture(NextDepartureCalculatorRequest request);
}
