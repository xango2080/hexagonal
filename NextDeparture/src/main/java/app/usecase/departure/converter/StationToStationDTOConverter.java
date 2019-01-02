package app.usecase.departure.converter;

import app.common.Converter;
import app.usecase.departure.dto.StationDTO;
import domain.model.Station;

public class StationToStationDTOConverter implements Converter<Station, StationDTO> {

	private DisruptionToDisruptionDTOConverter disruptionToDisruptionDTOConverter = new DisruptionToDisruptionDTOConverter();

	@Override
	public StationDTO apply(Station station) {
		return new StationDTO(station.getLabel(), disruptionToDisruptionDTOConverter.convertToList(station.getDisruptions()));
	}

}
