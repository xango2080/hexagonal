package app.usecase.departure.dto;

import java.util.ArrayList;
import java.util.Collection;

public class NextDepartureResponse {

	Collection<TrainDTO> trains = new ArrayList<>();

	private boolean serviceUnavailable;
}
