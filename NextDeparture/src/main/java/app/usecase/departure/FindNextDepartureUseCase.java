package app.usecase.departure;

import app.usecase.departure.converter.NextDepartureToNextDepartureResponseConverter;
import app.usecase.departure.dto.NextDepartureResponse;
import domain.model.NextDeparture;
import domain.service.NextDepartureCalculator;

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
