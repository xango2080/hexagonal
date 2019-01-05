package infra.inmemory;

import domain.model.*;
import domain.repository.NextDepartureRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryNextDepartureNextAdapterRepository implements NextDepartureRepository {

    private final Set<NextDeparture> nextDepartures;

    public InMemoryNextDepartureNextAdapterRepository() {
        this.nextDepartures = new HashSet<NextDeparture>();
        loadData();
    }

    private void loadData() {
        Train aaaa = new Train("AAAA", "");
        Train bbbb = new Train("BBBB", "");
        Train cccc = new Train("CCCC", "");
        Train dddd = new Train("DDDD", "");

        Station stationA = new Station("station a", Collections.emptyList());
        Station stationB = new Station("station b", Collections.singletonList(new Disruption("Malaise voyageur", LocalDateTime.of(2019, 01, 19, 8, 0, 0))));
        Station stationC = new Station("station c", Collections.emptyList());
        Station stationD = new Station("station d", Collections.emptyList());
        Station stationE = new Station("station d", Collections.emptyList());
        Station stationF = new Station("station d", Collections.emptyList());
        LocalDateTime now = LocalDateTime.now();
        NextDeparture sncf = NextDepartureBuilder
                .builder()
                .withTrain(aaaa)
                .withArrival(stationA)
                .withDepartureTime(LocalTime.of(8, 30))
                .withPlatform("SNCF")
                .withStations(Collections.singletonList(stationB))
                .build();
        NextDeparture departureB = NextDepartureBuilder
                .builder()
                .withTrain(bbbb)
                .withArrival(stationA)
                .withDepartureTime(LocalTime.of(8, 35))
                .withPlatform("SNCF")
                .withStations(Arrays.asList(stationC, stationF))
                .build();
        NextDeparture departureC = NextDepartureBuilder
                .builder()
                .withTrain(cccc)
                .withArrival(stationA)
                .withDepartureTime(LocalTime.of(now.getHour(), 32))
                .withPlatform("SNCF")
                .withStations(Collections.singletonList(stationF))
                .build();
        NextDeparture departureF = NextDepartureBuilder
                .builder()
                .withTrain(cccc)
                .withArrival(stationA)
                .withDepartureTime(LocalTime.now().plusMinutes(30))
                .withPlatform("SNCF")
                .withStations(Collections.emptyList())
                .build();
        NextDeparture departureD = NextDepartureBuilder
                .builder()
                .withTrain(dddd)
                .withArrival(stationD)
                .withDepartureTime(LocalTime.now().plusMinutes(29))
                .withPlatform("SNCF")
                .withStations(Collections.emptyList())
                .build();
        nextDepartures.addAll(Arrays.asList(sncf, departureB, departureC, departureF, departureD));
    }

    @Override
    public Collection<NextDeparture> retrieveNext(String station, Instant departureTime, long maxResults) {
        LocalTime loc = LocalTime.from(departureTime.atZone(ZoneId.systemDefault()));
        return this.nextDepartures
                .stream()
                .filter(nextDeparture -> isEquals(station, nextDeparture, loc))
                .collect(Collectors.toSet());
    }

    private boolean isEquals(String station, NextDeparture nextDeparture, LocalTime localTime) {
        return nextDeparture.getArrival().getLabel().contains(station) && nextDeparture.getDepartureTime().isAfter(localTime);
    }

}
