package com.xango.nextdeparture.domain.service;

import com.xango.nextdeparture.domain.model.request.NextDepartureCalculatorRequest;
import com.xango.nextdeparture.domain.model.response.NextDepartureCalculatorResponse;

public interface NextDepartureCalculator {
    NextDepartureCalculatorResponse computeNextDeparture(NextDepartureCalculatorRequest request);
}
