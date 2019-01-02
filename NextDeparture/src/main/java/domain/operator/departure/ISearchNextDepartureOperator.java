package domain.operator.departure;

import java.util.Collection;

import domain.model.NextDeparture;

public interface ISearchNextDepartureOperator {

	Collection<NextDeparture> researchAllNextDepartureFromDeparture(String label);
}
