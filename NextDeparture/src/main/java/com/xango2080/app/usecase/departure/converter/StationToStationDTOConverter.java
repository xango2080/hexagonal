package com.xango2080.app.usecase.departure.converter;

import com.xango2080.app.common.Converter;
import com.xango2080.app.usecase.departure.dto.StationDTO;
import com.xango2080.domain.model.Station;

public class StationToStationDTOConverter implements Converter<Station, StationDTO> {

	private DisruptionToDisruptionDTOConverter disruptionToDisruptionDTOConverter = new DisruptionToDisruptionDTOConverter();

	@Override
	public StationDTO apply(Station station) {
		return new StationDTO(station.getLabel(), disruptionToDisruptionDTOConverter.convertToList(station.getDisruptions()));
	}

}
