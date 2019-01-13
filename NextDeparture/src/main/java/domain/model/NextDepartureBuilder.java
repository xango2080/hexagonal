package domain.model;

import annotation.ddd.Builder;

import java.time.LocalTime;
import java.util.*;

@Builder
public class NextDepartureBuilder {

	private LocalTime departureTime;
	private String platform;
	private Train train;
	private HashSet<Station> stations;
	private String station;

	private NextDepartureBuilder() {

	}

	public static NextDepartureBuilder builder() {
		return new NextDepartureBuilder();
	}


	public NextDepartureBuilder withDepartureTime(LocalTime time) {
		this.departureTime = time;
		return this;
	}

	public NextDepartureBuilder withPlatform(String platform) {
		this.platform = platform;
		return this;
	}

	public NextDepartureBuilder withTrain(Train train) {
		this.train = train;
		return this;
	}

	public NextDepartureBuilder withStations(Collection<Station> stations) {
		this.stations = new HashSet<>(stations);
		return this;
	}

	public NextDeparture build() {
		return null;
	}

}
