package com.xango.nextdeparture.app.gateway.inmemory;

import com.xango.nextdeparture.domain.service.DefaultNextDepartureCalculator;
import com.xango.nextdeparture.domain.service.NextDepartureCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@InMemory
public class InMemoryNextDepartureCalculatorConfiguration {

    @Bean
    public NextDepartureCalculator nextDepartureCalculator(){
        return new DefaultNextDepartureCalculator(new InMemorySearchNextDepartureAdapter());
    }

}
