package com.xango.nextdeparture.app.rest;

import com.xango.nextdeparture.domain.model.request.NextDepartureCalculatorRequest;
import com.xango.nextdeparture.domain.model.response.NextDepartureCalculatorResponse;
import com.xango.nextdeparture.domain.service.NextDepartureCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class NextDepartureCalculatorRestAdapter {

    private final NextDepartureCalculator nextDepartureCalculator;

    @Autowired
    public NextDepartureCalculatorRestAdapter(NextDepartureCalculator nextDepartureCalculator) {
        this.nextDepartureCalculator = nextDepartureCalculator;
    }

    @GetMapping("/geolocalisation/departures/next")
    public Iterable<GeolocalisationNextDeparture> next(@RequestParam String station) {
        return transformToGeolocalisation(nextDepartureCalculator.computeNextDeparture(new NextDepartureCalculatorRequest(station, Instant.now(), 4)));
    }

    @GetMapping("/transilien/departures/next")
    public Iterable<TransilienNextDeparture> next(@RequestParam String station, @RequestParam Instant date) {
        return transformIntTransilienList(nextDepartureCalculator.computeNextDeparture(new NextDepartureCalculatorRequest(station, date, 500)));
    }

    private Iterable<GeolocalisationNextDeparture> transformToGeolocalisation(NextDepartureCalculatorResponse response) {
        return response.getResults().stream().map(GeolocalisationNextDeparture::new).collect(Collectors.toList());
    }

    private Iterable<TransilienNextDeparture> transformIntTransilienList(NextDepartureCalculatorResponse response) {
        return response.getResults().stream().map(TransilienNextDeparture::new).collect(Collectors.toList());
    }
}
