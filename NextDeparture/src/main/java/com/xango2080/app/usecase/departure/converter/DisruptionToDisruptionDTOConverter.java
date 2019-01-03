package com.xango2080.app.usecase.departure.converter;

import com.xango2080.app.common.Converter;
import com.xango2080.app.usecase.departure.dto.DisruptionDTO;
import com.xango2080.domain.model.Disruption;

public class DisruptionToDisruptionDTOConverter implements Converter<Disruption, DisruptionDTO> {

	@Override
	public DisruptionDTO apply(Disruption disruption) {
		return new DisruptionDTO(disruption.getDate(), disruption.getTitle());
	}

}
