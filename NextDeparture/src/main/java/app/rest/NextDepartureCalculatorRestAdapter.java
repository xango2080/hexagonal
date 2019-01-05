package app.rest;

import domain.model.NextDeparture;
import domain.service.NextDepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class NextDepartureCalculatorRestAdapter {

    private final NextDepartureService nextDepartureService;

    @Autowired
    public NextDepartureCalculatorRestAdapter(NextDepartureService nextDepartureService) {
        this.nextDepartureService = nextDepartureService;
    }

    @GetMapping("/geolocalisation/departures/next")
    public Iterable<GeolocalisationNextDeparture> next(@RequestParam String station) {
        return transformToGeolocalisation(nextDepartureService.findByStationAndDepartureTime(station, Instant.now()));
    }

    @GetMapping("/transilien/departures/next")
    public Iterable<TransilienNextDeparture> next(@RequestParam String station, @RequestParam Instant date) {
        return transformIntTransilienList(nextDepartureService.findByStationAndDepartureTime(station, date));
    }

    private Iterable<GeolocalisationNextDeparture> transformToGeolocalisation(Collection<NextDeparture> departureList){
       return departureList.stream().map(GeolocalisationNextDeparture::new).collect(Collectors.toList());
    }

    private Iterable<TransilienNextDeparture> transformIntTransilienList(Collection<NextDeparture> departureList){
        return departureList.stream().map(TransilienNextDeparture::new).collect(Collectors.toList());
    }
}
