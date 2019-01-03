package com.xango2080.app.usecase.departure.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Collection;

public class NextDepartureResponse implements Serializable {

	private LocalTime departureTime;

	private String platform;

	private StationDTO arrival;

	private TrainDTO train;

	private Collection<StationDTO> stations;

	private boolean hasDisruption;

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public StationDTO getArrival() {
		return arrival;
	}

	public void setArrival(StationDTO arrival) {
		this.arrival = arrival;
	}

	public TrainDTO getTrain() {
		return train;
	}

	public void setTrain(TrainDTO train) {
		this.train = train;
	}

	public Collection<StationDTO> getStations() {
		return stations;
	}

	public void setStations(Collection<StationDTO> stations) {
		this.stations = stations;
	}

	public boolean isHasDisruption() {
		return hasDisruption;
	}

	public void setHasDisruption(boolean hasDisruption) {
		this.hasDisruption = hasDisruption;
	}
}
