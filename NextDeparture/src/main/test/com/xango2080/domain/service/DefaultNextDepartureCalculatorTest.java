package com.xango2080.domain.service;


import com.xango2080.domain.repository.SearchDeparture;
import com.xango2080.domain.model.NextDeparture;
import com.xango2080.domain.model.NextDepartureBuilder;
import com.xango2080.domain.model.Station;
import com.xango2080.domain.model.Train;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DefaultNextDepartureCalculatorTest {

    @Test
    public void findNextDeparture_should_failed_with_invalid_station() throws Exception {
        DefaultNextDepartureCalculator defaultNextDepartureCalculator = new DefaultNextDepartureCalculator(new EmptySearchDeparture());
        assertThatThrownBy(() -> defaultNextDepartureCalculator.computeNextDepartureFrom(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void findNextDeparture_should_not_retrieve_next_departure() throws Exception {
        DefaultNextDepartureCalculator defaultNextDepartureCalculator = new DefaultNextDepartureCalculator(new EmptySearchDeparture());
        Collection<NextDeparture> nextDeparture = defaultNextDepartureCalculator.computeNextDepartureFrom("MyGare");
        assertThat(nextDeparture).isEmpty();
    }

    @Test
    public void findNextDeparture_should_retrieve_only_one_departure() throws Exception {
        DefaultNextDepartureCalculator defaultNextDepartureCalculator = new DefaultNextDepartureCalculator(new InMemoryRandomSearchDeparture(1));
        Collection<NextDeparture> nextDeparture = defaultNextDepartureCalculator.computeNextDepartureFrom("AGare");
        NextDeparture expectedNextDeparture = NextDepartureBuilder
                .builder()
                .withArrival(new Station("station 1", Collections.emptyList()))
                .withDepartureTime(LocalTime.of(8, 0))
                .withPlatform("PLATFORM")
                .withTrain(new Train("XXXX","aMission"))
                .withStations(Collections.emptyList())
                .build();
        assertThat(nextDeparture).contains(expectedNextDeparture);
    }


    class EmptySearchDeparture implements SearchDeparture {

        @Override
        public Collection<NextDeparture> findByStation(String station) {
            return Collections.emptyList();
        }
    }

    class InMemoryRandomSearchDeparture implements SearchDeparture {

        private List<NextDeparture> departures;

        public InMemoryRandomSearchDeparture(int numberOfDepature) {
             departures = IntStream
                    .rangeClosed(1, numberOfDepature)
                    .mapToObj(i -> {
                        return NextDepartureBuilder
                                .builder()
                                .withArrival(new Station(String.format("station %d", i % 3), Collections.emptyList()))
                                .withDepartureTime(LocalTime.of(8, 0))
                                .withPlatform("PLATFORM")
                                .withTrain(new Train("XXXX", "aMission"))
                                .withStations(Collections.emptyList())
                                .build();
                    }).collect(Collectors.toList());
        }

        @Override
        public Collection<NextDeparture> findByStation(String station) {
            return departures;
        }
    }

}
