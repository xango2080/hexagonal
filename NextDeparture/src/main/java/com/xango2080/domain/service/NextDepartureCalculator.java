package com.xango2080.domain.service;

import com.xango2080.domain.model.NextDeparture;

import java.util.Collection;

public interface NextDepartureCalculator {
    Collection<NextDeparture> computeNextDepartureFrom(String station);
}
