package com.xango2080.infra.inmemory;

import com.xango2080.domain.model.NextDeparture;
import com.xango2080.domain.repository.SearchDeparture;

import java.util.Collection;
import java.util.Collections;

public class InMemorySearchDepartureAdapter implements SearchDeparture {
    @Override
    public Collection<NextDeparture> findByStation(String station) {
        return Collections.emptyList();
    }
}
