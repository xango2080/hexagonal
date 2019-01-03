package com.xango2080.app.rest;

import com.xango2080.domain.model.NextDeparture;
import com.xango2080.domain.service.NextDepartureCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class NextDepartureCalculatorRestAdapter {

    private final NextDepartureCalculator nextDepartureCalculator;

    @Autowired
    public NextDepartureCalculatorRestAdapter(NextDepartureCalculator nextDepartureCalculator) {
        this.nextDepartureCalculator = nextDepartureCalculator;
    }

    @GetMapping("/departures/next")
    public Collection<NextDeparture> next(@RequestParam String station) {
        return nextDepartureCalculator.computeNextDepartureFrom(station);
    }
}
