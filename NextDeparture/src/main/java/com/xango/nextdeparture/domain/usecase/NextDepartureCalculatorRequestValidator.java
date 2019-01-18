package com.xango.nextdeparture.domain.usecase;

import com.xango.nextdeparture.domain.model.exception.InvalidNextDepartureQueryException;
import com.xango.nextdeparture.domain.model.request.NextDepartureCalculatorRequest;

import java.time.Instant;

public class NextDepartureCalculatorRequestValidator {

    public void validateNextDepartureCalculatorRequest(NextDepartureCalculatorRequest request) {
        if (request == null) {
            throw new InvalidNextDepartureQueryException();
        }

        if (request.getStation() == null || request.getStation().isEmpty()) {
            throw new InvalidNextDepartureQueryException();
        }

        if (request.getDepartureDate().isBefore(Instant.now())) {
            throw new InvalidNextDepartureQueryException();
        }
    }
}
