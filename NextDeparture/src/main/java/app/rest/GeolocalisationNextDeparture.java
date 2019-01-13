package app.rest;

import domain.model.NextDeparture;

public class GeolocalisationNextDeparture {

    private final String hour;
    private final String train;
    private final boolean disruption;

    public GeolocalisationNextDeparture(NextDeparture nextDeparture) {
        this.hour = nextDeparture.getArrivalTime().toString();
        this.train = null;
        this.disruption = false;
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
