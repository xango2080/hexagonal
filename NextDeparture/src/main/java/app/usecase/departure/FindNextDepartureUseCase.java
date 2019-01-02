package app.usecase.departure;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.usecase.departure.config.FindNextDepartureUseCaseModel;
import app.usecase.departure.converter.NextDepartureToNextDepartureResponseConverter;
import app.usecase.departure.dto.NextDepartureResponse;
import domain.model.NextDeparture;
import domain.operator.departure.ISearchNextDepartureOperator;

@RestController
public class FindNextDepartureUseCase {

	private ISearchNextDepartureOperator operator;

	private NextDepartureToNextDepartureResponseConverter converter;

	public FindNextDepartureUseCase(@Autowired FindNextDepartureUseCaseModel model) {
		if (model.getOperator() == null || model.getConverter() == null) {
			throw new IllegalArgumentException();
		}
		operator = model.getOperator();
		converter = model.getConverter();
	}

	@GetMapping
	public Collection<NextDepartureResponse> find(@RequestParam String label) {

		Collection<NextDeparture> nextDepartures = operator.researchAllNextDepartureFromDeparture(label);

		return converter.convertToList(nextDepartures);
	}

}
