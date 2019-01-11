package app.configuration.inmemory;

import domain.service.DefaultNextDepartureCalculator;
import domain.service.NextDepartureCalculator;
import infra.inmemory.InMemoryNextDepartureSearchAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@InMemory
public class InMemoryNextDepartureCalculatorConfiguration {

    @Bean
    public NextDepartureCalculator nextDepartureCalculator(){
        return new DefaultNextDepartureCalculator(new InMemoryNextDepartureSearchAdapter());
    }

}
