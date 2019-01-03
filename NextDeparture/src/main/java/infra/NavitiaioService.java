package infra;

import java.util.ArrayList;
import java.util.Collection;

import domain.repository.SearchDeparture;
import domain.model.NextDeparture;

public class NavitiaioService implements SearchDeparture {

	@Override
	public Collection<NextDeparture> retrieveNext(String station) {
		return new ArrayList<>();
	}
}
