package com.xango.nextdeparture.domain.model;

import com.xango.nextdeparture.annotation.ddd.ValueObject;

import java.time.LocalTime;

@ValueObject
public class NextDeparture {

	private Train train;
	private Station station;
	private String platform;
	private LocalTime arrivalTime;

	public NextDeparture(Train train, Station station, String platform, LocalTime arrivalTime) {
		this.train = train;
		this.station = station;
		this.platform = platform;
		this.arrivalTime = arrivalTime;
	}

	public Train getTrain() {
		return train;
	}

	public Station getStation() {
		return station;
	}

	public String getPlatform() {
		return platform;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
}
