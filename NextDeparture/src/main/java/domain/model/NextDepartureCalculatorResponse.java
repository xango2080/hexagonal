package domain.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class NextDepartureCalculatorResponse {

    private final Collection<NextDeparture> results;
    private final NextDepartureSearchQuery query;

    public NextDepartureCalculatorResponse(Collection<NextDeparture> results, NextDepartureSearchQuery query) {
        Objects.requireNonNull(query, "query can't be null");
        this.results = results;
        this.query = query;
    }

    public static final NextDepartureCalculatorResponse empty(NextDepartureSearchQuery query) {
        return new NextDepartureCalculatorResponse(Collections.emptyList(), query);
    }

    public boolean isEmpty(){
        return equals(empty(query));
    }

    public Collection<NextDeparture> getResults() {
        return results;
    }

    public String getStationName() {
        return query.getStation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NextDepartureCalculatorResponse)) {
            return false;
        }
        NextDepartureCalculatorResponse that = (NextDepartureCalculatorResponse) o;
        return Objects.equals(getResults(), that.getResults()) &&
                Objects.equals(query, that.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResults(), query);
    }
}
