package com.xango2080.domain.service;

import javax.inject.Named;

public class ConfigService {

	@Named("findNextDeparture")
	public NextDepartureService findNextDeparture() {
		return new NextDepartureService();
	}
}
