package domain.model;

import java.time.Instant;
import java.util.Objects;

public class NextDepartureSearchQuery {

    private final String station;
    private final Instant departureDate;
    private final long maxResults;

    public NextDepartureSearchQuery(String station, Instant departureDate, long maxResults) {
        this.station = station;
        this.departureDate = departureDate;
        this.maxResults = maxResults;
    }

    public String getStation() {
        return station;
    }

    public Instant getDepartureDate() {
        return departureDate;
    }

    public long getMaxResults() {
        return maxResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NextDepartureSearchQuery)) {
            return false;
        }
        NextDepartureSearchQuery that = (NextDepartureSearchQuery) o;
        return getMaxResults() == that.getMaxResults() &&
                Objects.equals(getStation(), that.getStation()) &&
                Objects.equals(getDepartureDate(), that.getDepartureDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStation(), getDepartureDate(), getMaxResults());
    }
}
