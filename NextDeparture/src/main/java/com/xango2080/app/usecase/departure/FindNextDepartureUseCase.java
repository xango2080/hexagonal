package com.xango2080.app.usecase.departure;

import com.xango2080.app.usecase.departure.converter.NextDepartureToNextDepartureResponseConverter;
import com.xango2080.app.usecase.departure.dto.NextDepartureResponse;
import com.xango2080.domain.service.NextDepartureCalculator;

import java.util.Collection;
import java.util.stream.Collectors;

public class FindNextDepartureUseCase {

	private final NextDepartureCalculator nextDepartureCalculator;
	private final NextDepartureToNextDepartureResponseConverter converter;

	public FindNextDepartureUseCase(NextDepartureCalculator nextDepartureCalculator, NextDepartureToNextDepartureResponseConverter converter) {
		this.nextDepartureCalculator = nextDepartureCalculator;
		this.converter = converter;
	}

	public Collection<NextDepartureResponse> compute(String station) {
		return nextDepartureCalculator
				.computeNextDepartureFrom(station)
				.stream()
				.map(converter::apply)
				.collect(Collectors.toList());
	}

}
