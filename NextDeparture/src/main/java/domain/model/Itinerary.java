package domain.model;

import java.util.Set;
import java.util.stream.Collectors;

public class Itinerary {

    private final Set<Station> stations;
    private final Station station;
    private final String platform;
    private final Set<String> disruptions;

    public Itinerary(Set<Station> stations, Station station, String platform) {
        this.stations = stations;
        this.station = station;
        this.platform = platform;
        this.disruptions = stations.stream().flatMap(s -> s.getDisruptions().stream()).map(Disruption::getTitle).collect(Collectors.toSet());
    }

    public Station getFrom() {
        return this.stations.stream().findFirst().orElse(Station.NULL);
    }

    public Station getArrival() {
        return this.stations.stream().skip(stations.size() - 1).findFirst().orElse(Station.NULL);
    }

    public Station getStation() {
        return station;
    }

    public String getPlatform() {
        return platform;
    }

    public Set<Station> getStations() {
        return stations;
    }

    public boolean isDisrupted() {
        return !disruptions.isEmpty();
    }

    public Set<String> disruptions() {
        return disruptions;
    }
}
