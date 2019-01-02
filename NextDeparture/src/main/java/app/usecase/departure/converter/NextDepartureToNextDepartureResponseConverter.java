package app.usecase.departure.converter;

import app.common.Converter;
import app.usecase.departure.dto.NextDepartureResponse;
import domain.model.NextDeparture;

public class NextDepartureToNextDepartureResponseConverter implements Converter<NextDeparture, NextDepartureResponse> {

	@Override
	public NextDepartureResponse apply(NextDeparture nextDeparture) {
		return null;
	}

}
