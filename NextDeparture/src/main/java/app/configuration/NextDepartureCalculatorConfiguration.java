package app.configuration;

import domain.service.DefaultNextDepartureService;
import domain.service.NextDepartureService;
import infra.inmemory.InMemoryNextDepartureNextAdapterRepository;
import infra.jdbc.JdbcTemplateNextDepartureRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class NextDepartureCalculatorConfiguration {

    @Bean
    @Profile("inmemory")
    public NextDepartureService nextDepartureService(){
        return new DefaultNextDepartureService(new InMemoryNextDepartureNextAdapterRepository(), 500);
    }

    @Bean
    @Profile("production")
    public NextDepartureService nextDepartureService(JdbcTemplate jdbcTemplate){
        return new DefaultNextDepartureService(new JdbcTemplateNextDepartureRepositoryAdapter(jdbcTemplate), 500);
    }
}
