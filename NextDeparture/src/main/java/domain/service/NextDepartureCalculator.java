package domain.service;

import domain.model.request.NextDepartureCalculatorRequest;
import domain.model.response.NextDepartureCalculatorResponse;

public interface NextDepartureCalculator {
    NextDepartureCalculatorResponse computeNextDeparture(NextDepartureCalculatorRequest request);
}
