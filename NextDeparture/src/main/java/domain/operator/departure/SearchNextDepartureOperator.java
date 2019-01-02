package domain.operator.departure;

import java.util.Collection;

import domain.model.NextDeparture;
import domain.service.FindNextDeparture;

public class SearchNextDepartureOperator implements ISearchNextDepartureOperator {

	private FindNextDeparture findNextDeparture;

	SearchNextDepartureOperator(FindNextDeparture findNextDeparture) {
		if (findNextDeparture == null) {
			throw new IllegalArgumentException("test");
		}
		this.findNextDeparture = findNextDeparture;
	}

	@Override
	public Collection<NextDeparture> researchAllNextDepartureFromDeparture(String label) {
		return findNextDeparture.find(label);
	}
}
