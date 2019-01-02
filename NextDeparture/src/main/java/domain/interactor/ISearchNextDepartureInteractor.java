package domain.interactor;

import java.util.Collection;

import domain.model.NextDeparture;

public interface ISearchNextDepartureInteractor {

	Collection<NextDeparture> find(String station);
}
