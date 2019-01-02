package domain.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NextDepartureBuilder {

	private LocalTime departureTime;

	private String platform;

	private Station arrival;

	private Train train;

	private List<Station> stations;

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

	public NextDepartureBuilder withArrival(Station arrival) {
		this.arrival = arrival;
		return this;
	}

	public NextDepartureBuilder withTrain(Train train) {
		this.train = train;
		return this;
	}

	public NextDepartureBuilder withStations(Collection<Station> stations) {
		this.stations = new ArrayList<>(stations);
		return this;
	}

	public NextDeparture build() {
		return new NextDeparture(departureTime, platform, arrival, train, stations);
	}

}
