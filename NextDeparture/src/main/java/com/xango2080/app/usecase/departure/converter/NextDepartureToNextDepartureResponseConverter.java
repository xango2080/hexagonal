package com.xango2080.app.usecase.departure.converter;

import java.util.Collection;

import com.xango2080.app.common.Converter;
import com.xango2080.app.usecase.departure.dto.NextDepartureResponse;
import com.xango2080.app.usecase.departure.dto.StationDTO;
import com.xango2080.domain.model.NextDeparture;

public class NextDepartureToNextDepartureResponseConverter implements Converter<NextDeparture, NextDepartureResponse> {

	private StationToStationDTOConverter stationToStationDTOConverter = new StationToStationDTOConverter();
	private TrainToTrainDTOConverter trainToTrainDTOConverter = new TrainToTrainDTOConverter();

	@Override
	public NextDepartureResponse apply(NextDeparture nextDeparture) {
		NextDepartureResponse response = new NextDepartureResponse();

		Collection<StationDTO> stations = stationToStationDTOConverter.convertToList(nextDeparture.getStations());
		response.setStations(stations);
		response.setArrival(stationToStationDTOConverter.apply(nextDeparture.getArrival()));
		response.setDepartureTime(nextDeparture.getDepartureTime());
		response.setPlatform(nextDeparture.getPlatform());
		response.setTrain(trainToTrainDTOConverter.apply(nextDeparture.getTrain()));
		response.setHasDisruption(stations.stream().anyMatch(t -> !t.getDisruptions().isEmpty()));

		return response;
	}

}
