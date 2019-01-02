package domain.service;

import javax.inject.Named;

public class ConfigService {

	@Named("findNextDeparture")
	public FindNextDeparture findNextDeparture() {
		return new FindNextDeparture();
	}
}
