package app.rest;

import domain.model.NextDeparture;

public class GeolocalisationNextDeparture {

    private final String hour;
    private final String train;
    private final boolean disruption;

    public GeolocalisationNextDeparture(NextDeparture nextDeparture) {
        this.hour = nextDeparture.getDepartureTime().toString();
        this.train = nextDeparture.getTrain().getCode();
        this.disruption = !nextDeparture.getArrival().getDisruptions().isEmpty();
    }

    public String getHour() {
        return hour;
    }

    public String getTrain() {
        return train;
    }

    public boolean isDisruption() {
        return disruption;
    }
}
