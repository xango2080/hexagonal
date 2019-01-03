package com.xango2080.domain.repository;

import java.util.Collection;

import com.xango2080.domain.model.NextDeparture;

public interface SearchDeparture {

	Collection<NextDeparture> findByStation(String station);
}
