package com.xango2080.app.configuration;

import com.xango2080.domain.service.DefaultNextDepartureCalculator;
import com.xango2080.domain.service.NextDepartureCalculator;
import com.xango2080.infra.inmemory.InMemorySearchDepartureAdapter;
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
