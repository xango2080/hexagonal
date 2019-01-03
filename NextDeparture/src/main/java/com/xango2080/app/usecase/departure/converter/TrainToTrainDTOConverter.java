package com.xango2080.app.usecase.departure.converter;

import com.xango2080.app.common.Converter;
import com.xango2080.app.usecase.departure.dto.TrainDTO;
import com.xango2080.domain.model.Train;

public class TrainToTrainDTOConverter implements Converter<Train, TrainDTO> {

	@Override
	public TrainDTO apply(Train train) {
		return new TrainDTO(train.getCode(), train.getMission());
	}
}
