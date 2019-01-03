package com.xango2080.domain.service;

import com.xango2080.domain.model.NextDeparture;
import com.xango2080.domain.repository.SearchDeparture;
import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.Objects;

public class DefaultNextDepartureCalculator implements NextDepartureCalculator {

	private final SearchDeparture searchDeparture;

	public DefaultNextDepartureCalculator(@NonNull SearchDeparture searchDeparture) {
		Objects.requireNonNull(searchDeparture, "searchDeparture can't be null");
		this.searchDeparture = searchDeparture;
	}

	@Override
	public Collection<NextDeparture> computeNextDepartureFrom(String station){
		checkStation(station);
		return searchDeparture.findByStation(station);
	}

	private void checkStation(String station) {
		if(station == null) {
			throw new IllegalArgumentException("Station name is invalid");
		}
	}

}
