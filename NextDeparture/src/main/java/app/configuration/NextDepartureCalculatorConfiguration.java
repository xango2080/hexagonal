package app.configuration;

import domain.service.DefaultNextDepartureCalculator;
import domain.service.NextDepartureCalculator;
import infra.inmemory.InMemorySearchDepartureAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class NextDepartureCalculatorConfiguration {

    @Bean
    public NextDepartureCalculator nextDepartureCalculator(JdbcTemplate jdbcTemplate){
        return new DefaultNextDepartureCalculator(new InMemorySearchDepartureAdapter());
    }

}
