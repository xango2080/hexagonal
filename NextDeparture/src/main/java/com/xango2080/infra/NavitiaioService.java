package com.xango2080.infra;

import java.util.ArrayList;
import java.util.Collection;

import com.xango2080.domain.repository.SearchDeparture;
import com.xango2080.domain.model.NextDeparture;

public class NavitiaioService implements SearchDeparture {

	@Override
	public Collection<NextDeparture> findByStation(String station) {
		return new ArrayList<>();
	}
}
