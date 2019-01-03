package app.configuration;

import app.usecase.departure.FindNextDepartureUseCase;
import app.usecase.departure.converter.NextDepartureToNextDepartureResponseConverter;
import domain.service.NextDepartureCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NextDepartureUseCaseConfiguration {

    @Autowired
    private NextDepartureCalculator nextDepartureCalculator;

    @Bean
    public FindNextDepartureUseCase findNextDepartureUseCase() {
        return new FindNextDepartureUseCase(nextDepartureCalculator, new NextDepartureToNextDepartureResponseConverter());
    }
}
