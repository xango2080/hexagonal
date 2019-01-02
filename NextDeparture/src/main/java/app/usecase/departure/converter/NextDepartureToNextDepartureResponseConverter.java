package app.usecase.departure.converter;

import java.util.Collection;

import app.common.Converter;
import app.usecase.departure.dto.NextDepartureResponse;
import app.usecase.departure.dto.StationDTO;
import domain.model.NextDeparture;

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
