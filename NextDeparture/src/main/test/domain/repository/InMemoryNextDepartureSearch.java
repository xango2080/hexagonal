package domain.repository;

import domain.model.Disruption;
import domain.model.NextDeparture;
import domain.model.Station;
import domain.model.Train;
import domain.model.search.NextDepartureSearchQuery;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryNextDepartureSearch implements NextDepartureSearch {

    private final Set<NextDeparture> nextDepartures;

    public InMemoryNextDepartureSearch() {
        this.nextDepartures = new HashSet<>();
        loadData();
    }

    private void loadData() {
        Train rerA = Train.builder()
                .withCode("RER A")
                .withMission("This is my mission")
                .builder();
        Train t2 = Train.builder()
                .withCode("t2")
                .withMission("This is my mission")
                .builder();
        Train transilienL = Train.builder()
                .withCode("L")
                .withMission("This is my mission")
                .builder();
        Train transilienL2 = Train.builder()
                .withCode("L2")
                .withMission("This is my mission")
                .builder();


        Station la_défense = Station.builder()
                .withLabel("La Défense")
                .addDisruption(new Disruption("Problem", LocalDateTime.now()))
                .builder();
        Station becon = Station.builder()
                .withLabel("Becon les Bruyères")
                .builder();
        Station courbevoie = Station.builder()
                .withLabel("Courbevoie")
                .builder();
        Station laGarenneColombes = Station.builder()
                .withLabel("La Garenne Colombes")
                .builder();
        Station asnieres = Station.builder()
                .withLabel("Asnières")
                .addDisruption(new Disruption("canalisation", LocalDateTime.now().plus(6, ChronoUnit.MINUTES)))
                .builder();

        Station cdg = Station.builder()
                .withLabel("Charles de Gaule Etoile")
                .builder();
        Station auber = Station.builder()
                .withLabel("Auber")
                .addDisruption(new Disruption("Problem", LocalDateTime.now()))
                .builder();
        Station chateler = Station.builder()
                .withLabel("")
                .addDisruption(new Disruption("Problem", LocalDateTime.now()))
                .builder();
        Station gareDeLyon = Station.builder()
                .withLabel("Gare de Lyon")
                .addDisruption(new Disruption("Problem", LocalDateTime.now()))
                .builder();

        nextDepartures.add(new NextDeparture(rerA, la_défense, "Voie1", LocalTime.now().plus(5, ChronoUnit.MINUTES)));
        nextDepartures.add(new NextDeparture(rerA, cdg, "Voie1", LocalTime.now().plus(7, ChronoUnit.MINUTES)));
        nextDepartures.add(new NextDeparture(rerA, auber, "Voie1", LocalTime.now().plus(12, ChronoUnit.MINUTES)));
        nextDepartures.add(new NextDeparture(rerA, chateler, "Voie1", LocalTime.now().plus(15, ChronoUnit.MINUTES)));
        nextDepartures.add(new NextDeparture(rerA, gareDeLyon, "Voie1", LocalTime.now().plus(23, ChronoUnit.MINUTES)));

        nextDepartures.add(new NextDeparture(t2, la_défense, "Voie1", LocalTime.now().plus(3, ChronoUnit.MINUTES)));

        nextDepartures.add(new NextDeparture(transilienL, la_défense, "Voie1", LocalTime.now().plus(7, ChronoUnit.MINUTES)));
        nextDepartures.add(new NextDeparture(transilienL, courbevoie, "Voie1", LocalTime.now().plus(9, ChronoUnit.MINUTES)));
        nextDepartures.add(new NextDeparture(transilienL, becon, "Voie1", LocalTime.now().plus(13, ChronoUnit.MINUTES)));

        nextDepartures.add(new NextDeparture(transilienL2, asnieres, "Voie1", LocalTime.now().plus(23, ChronoUnit.MINUTES)));
        nextDepartures.add(new NextDeparture(transilienL2, becon, "Voie2", LocalTime.now().plus(25, ChronoUnit.MINUTES)));
        nextDepartures.add(new NextDeparture(transilienL2, laGarenneColombes, "Voie1", LocalTime.now().plus(33, ChronoUnit.MINUTES)));
    }

    @Override
    public Collection<NextDeparture> retrieveNext(NextDepartureSearchQuery searchQuery) {
        LocalTime loc = LocalTime.from(searchQuery.getDepartureDate().atZone(ZoneId.systemDefault()));
        return this.nextDepartures
                .stream()
                .filter(itineraryPoint -> itineraryPoint.getStation().getLabel().contains(searchQuery.getStation()) && itineraryPoint.getArrivalTime().isAfter(loc))
                .limit(searchQuery.getMaxResults())
                .collect(Collectors.toSet());
    }
}
