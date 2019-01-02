package domain.model;

import java.time.LocalTime;
import java.util.List;

public class NextDeparture {

	private LocalTime departureTime;

	private String platform;

	private Station arrival;

	private Train train;

	private List<Station> stations;

	NextDeparture(LocalTime departureTime, String platform, Station arrival, Train train, List<Station> stations) {
		this.departureTime = departureTime;
		this.platform = platform;
		this.arrival = arrival;
		this.train = train;
		this.stations = stations;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public String getPlatform() {
		return platform;
	}

	public Station getArrival() {
		return arrival;
	}

	public Train getTrain() {
		return train;
	}

	public List<Station> getStations() {
		return stations;
	}
}
