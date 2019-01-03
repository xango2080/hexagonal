package domain.model;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class NextDeparture {

	private final LocalTime departureTime;

	private final String platform;

	private final Station arrival;

	private final Train train;

	private final List<Station> stations;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NextDeparture that = (NextDeparture) o;
		return Objects.equals(getDepartureTime(), that.getDepartureTime()) &&
			   Objects.equals(getPlatform(), that.getPlatform()) &&
			   Objects.equals(getArrival(), that.getArrival()) &&
			   Objects.equals(getTrain(), that.getTrain()) &&
			   Objects.equals(getStations(), that.getStations());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDepartureTime(), getPlatform(), getArrival(), getTrain(), getStations());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NextDeparture{");
		sb.append("departureTime=").append(departureTime);
		sb.append(", platform='").append(platform).append('\'');
		sb.append(", arrival=").append(arrival);
		sb.append(", train=").append(train);
		sb.append(", stations=").append(stations);
		sb.append('}');
		return sb.toString();
	}
}
