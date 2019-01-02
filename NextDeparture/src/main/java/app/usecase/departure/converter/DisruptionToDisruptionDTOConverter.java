package app.usecase.departure.converter;

import app.common.Converter;
import app.usecase.departure.dto.DisruptionDTO;
import domain.model.Disruption;

public class DisruptionToDisruptionDTOConverter implements Converter<Disruption, DisruptionDTO> {

	@Override
	public DisruptionDTO apply(Disruption disruption) {
		return new DisruptionDTO(disruption.getDate(), disruption.getTitle());
	}

}
