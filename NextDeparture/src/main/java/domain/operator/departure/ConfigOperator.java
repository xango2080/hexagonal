package domain.operator.departure;

import domain.service.FindNextDeparture;

public class ConfigOperator {

	private ConfigOperator() {

	}

	public SearchNextDepartureOperator searchNextDepartureOperator(FindNextDeparture findNextDeparture) {
		return new SearchNextDepartureOperator(findNextDeparture);
	}

}
