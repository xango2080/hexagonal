package com.xango.nextdeparture.domain.service;

import com.xango.nextdeparture.domain.model.NextDeparture;
import com.xango.nextdeparture.domain.model.exception.InvalidNextDepartureQueryException;
import com.xango.nextdeparture.domain.model.request.NextDepartureCalculatorRequest;
import com.xango.nextdeparture.domain.model.response.NextDepartureCalculatorResponse;
import com.xango.nextdeparture.domain.model.search.NextDepartureSearchQuery;
import com.xango.nextdeparture.domain.gateway.ErrorNextDepatureSearch;
import com.xango.nextdeparture.domain.gateway.InMemoryNextDepartureSearch;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DefaultNextDepartureCalculatorTest {

    private static final Predicate<NextDeparture> TIME_AFTER_NOX_PREDICATE = (p) -> p.getArrivalTime().isAfter(LocalTime.now());

    public void setUp() {
    }


    @Test
    public void should_not_comptureNextDeparture_with_invalid_request() throws Exception {
        NextDepartureCalculatorRequest nullDepartureSearchQuery = null;
        NextDepartureCalculatorRequest pastDepartureSearchQuery = new NextDepartureCalculatorRequest("station", Instant.now().minus(50, ChronoUnit.MINUTES), 5);
        NextDepartureCalculatorRequest noNameDepartureSearchQuery = new NextDepartureCalculatorRequest("", Instant.now().minus(50, ChronoUnit.MINUTES), 5);


        NextDepartureCalculator nextDepartureCalculator = new DefaultNextDepartureCalculator(new InMemoryNextDepartureSearch());
        assertThatThrownBy(() -> nextDepartureCalculator.computeNextDeparture(nullDepartureSearchQuery)).isInstanceOf(InvalidNextDepartureQueryException.class);
        assertThatThrownBy(() -> nextDepartureCalculator.computeNextDeparture(noNameDepartureSearchQuery)).isInstanceOf(InvalidNextDepartureQueryException.class);
        assertThatThrownBy(() -> nextDepartureCalculator.computeNextDeparture(pastDepartureSearchQuery)).isInstanceOf(InvalidNextDepartureQueryException.class);
    }

    @Test
    public void comptureNextDeparture_with_data() throws Exception {
        NextDepartureCalculatorRequest pastDepartureSearchQuery = new NextDepartureCalculatorRequest("La Défense", Instant.now().plus(1, ChronoUnit.MINUTES), 5);
        NextDepartureCalculator nextDepartureCalculator = new DefaultNextDepartureCalculator(new InMemoryNextDepartureSearch());
        NextDepartureCalculatorResponse nextDepartureCalculatorResponse = nextDepartureCalculator.computeNextDeparture(pastDepartureSearchQuery);
        assertNextDepartureCaculatorResponse(3, pastDepartureSearchQuery, nextDepartureCalculatorResponse);
    }

    @Test
    public void comptureNextDeparture_with_emptyResult() throws Exception {
        NextDepartureCalculatorRequest pastDepartureSearchQuery = new NextDepartureCalculatorRequest("unknown", Instant.now().plus(1, ChronoUnit.MINUTES), 5);
        NextDepartureCalculator nextDepartureCalculator = new DefaultNextDepartureCalculator(new InMemoryNextDepartureSearch());
        NextDepartureCalculatorResponse nextDepartureCalculatorResponse = nextDepartureCalculator.computeNextDeparture(pastDepartureSearchQuery);
        NextDepartureSearchQuery query = new NextDepartureSearchQuery(pastDepartureSearchQuery.getStation(), pastDepartureSearchQuery.getDepartureDate(), pastDepartureSearchQuery.getMaxResult());

        assertThat(nextDepartureCalculatorResponse).isEqualTo(NextDepartureCalculatorResponse.empty(query));
    }

    @Test
    public void comptureNextDeparture_return_null_when_blows_up() throws Exception {
        NextDepartureCalculatorRequest pastDepartureSearchQuery = new NextDepartureCalculatorRequest("unknown", Instant.now().plus(1, ChronoUnit.MINUTES), 5);
        NextDepartureCalculator nextDepartureCalculator = new DefaultNextDepartureCalculator(new ErrorNextDepatureSearch());
        NextDepartureCalculatorResponse nextDepartureCalculatorResponse = nextDepartureCalculator.computeNextDeparture(pastDepartureSearchQuery);
        assertThat(nextDepartureCalculatorResponse).isEqualTo(NextDepartureCalculatorResponse.NULL);
    }

    private void assertNextDepartureCaculatorResponse(int exceptedNumberOfResult, NextDepartureCalculatorRequest request, NextDepartureCalculatorResponse response) {
        assertThat(response.getResults()).hasSize(exceptedNumberOfResult);
        assertThat(response.getStationName()).isEqualTo(request.getStation());
        assertThat(response.getResults().stream().allMatch(TIME_AFTER_NOX_PREDICATE)).isTrue();
    }

}
