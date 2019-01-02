package domain.service;

import java.util.Collection;

import domain.interactor.ISearchNextDepartureInteractor;
import domain.model.NextDeparture;

public class FindNextDeparture {

	private ISearchNextDepartureInteractor searchNextDepartureInteractor;

	public Collection<NextDeparture> find(String station){
		return searchNextDepartureInteractor.find(station);
	}
}
