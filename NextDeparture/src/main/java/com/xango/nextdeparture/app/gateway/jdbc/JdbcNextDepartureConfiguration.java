package com.xango.nextdeparture.app.gateway.jdbc;

import com.xango.nextdeparture.domain.service.DefaultNextDepartureCalculator;
import com.xango.nextdeparture.domain.service.NextDepartureCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Profile("production")
public class JdbcNextDepartureConfiguration {
    @Bean
    public NextDepartureCalculator nextDepartureCalculator(JdbcTemplate jdbcTemplate){
        return new DefaultNextDepartureCalculator(new JdbcTemplateSearchNextDepartureAdapter(jdbcTemplate));
    }

}
