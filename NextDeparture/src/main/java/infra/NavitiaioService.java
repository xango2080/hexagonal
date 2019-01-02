package infra;

import java.util.ArrayList;
import java.util.Collection;

import domain.interactor.ISearchNextDepartureInteractor;
import domain.model.NextDeparture;

public class NavitiaioService implements ISearchNextDepartureInteractor {

	@Override
	public Collection<NextDeparture> find(String station) {
		return new ArrayList<>();
	}
}
