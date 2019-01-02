package app.usecase.departure.converter;

import app.common.Converter;
import app.usecase.departure.dto.NextDepartureResponse;
import app.usecase.departure.dto.TrainDTO;
import domain.model.NextDeparture;
import domain.model.NextDepartureBuilder;
import domain.model.Train;

public class TrainToTrainDTOConverter implements Converter<Train, TrainDTO> {

	@Override
	public TrainDTO apply(Train train) {
		return new TrainDTO(train.getCode(), train.getMission());
	}
}
