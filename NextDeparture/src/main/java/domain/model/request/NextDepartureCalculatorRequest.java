package domain.model.request;

import java.time.Instant;

public class NextDepartureCalculatorRequest {

    private final String station;
    private final Instant departureDate;
    private final int maxResult;

    public NextDepartureCalculatorRequest(String station, Instant departureDate, int maxResult) {
        this.station = station;
        this.departureDate = departureDate;
        this.maxResult = maxResult;
    }

    public String getStation() {
        return station;
    }

    public Instant getDepartureDate() {
        return departureDate;
    }

    public int getMaxResult() {
        return maxResult;
    }
}
