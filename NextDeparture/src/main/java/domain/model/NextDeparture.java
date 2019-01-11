package domain.model;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class NextDeparture {

	private final LocalTime departureTime;

	private final Itinerary itinerary;

	private final Train train;

	NextDeparture(LocalTime departureTime, Train train, Itinerary itinerary) {
		this.departureTime = departureTime;
		this.train = train;
		this.itinerary = itinerary;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public Train getTrain() {
		return train;
	}
}
