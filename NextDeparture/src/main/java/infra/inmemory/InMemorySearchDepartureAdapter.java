package infra.inmemory;

import domain.model.NextDeparture;
import domain.repository.SearchDeparture;

import java.util.Collection;
import java.util.Collections;

public class InMemorySearchDepartureAdapter implements SearchDeparture {
    @Override
    public Collection<NextDeparture> retrieveNext(String station) {
        return Collections.emptyList();
    }
}
