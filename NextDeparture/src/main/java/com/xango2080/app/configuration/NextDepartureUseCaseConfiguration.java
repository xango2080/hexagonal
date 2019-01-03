package com.xango2080.app.configuration;

import com.xango2080.app.usecase.departure.FindNextDepartureUseCase;
import com.xango2080.app.usecase.departure.converter.NextDepartureToNextDepartureResponseConverter;
import com.xango2080.domain.service.NextDepartureCalculator;
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
