package app.usecase.departure.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.usecase.departure.converter.NextDepartureToNextDepartureResponseConverter;
import domain.operator.departure.ISearchNextDepartureOperator;

@Configuration
public class FindNextDepartureUseCaseConfig {

	@Bean
	public FindNextDepartureUseCaseModel findNextDepartureUseCase(@Qualifier("searchNextDepartureOperator") ISearchNextDepartureOperator searchNextDepartureOperator) {
		return new FindNextDepartureUseCaseModel(searchNextDepartureOperator, new NextDepartureToNextDepartureResponseConverter());
	}
}
