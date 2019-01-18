package com.xango.nextdeparture.domain.gateway;

import com.xango.nextdeparture.domain.model.NextDeparture;
import com.xango.nextdeparture.domain.model.search.NextDepartureSearchQuery;

import java.util.Collection;

public interface SearchNextDeparture {

	Collection<NextDeparture> retrieveNext(NextDepartureSearchQuery query);
}
