package app.usecase.departure.config;

import app.usecase.departure.converter.NextDepartureToNextDepartureResponseConverter;
import domain.operator.departure.ISearchNextDepartureOperator;

public class FindNextDepartureUseCaseModel {

	public FindNextDepartureUseCaseModel(ISearchNextDepartureOperator operator, NextDepartureToNextDepartureResponseConverter converter) {
		this.operator = operator;
		this.converter = converter;
	}

	private ISearchNextDepartureOperator operator;

	private NextDepartureToNextDepartureResponseConverter converter;

	public ISearchNextDepartureOperator getOperator() {
		return operator;
	}

	public void setOperator(ISearchNextDepartureOperator operator) {
		this.operator = operator;
	}

	public NextDepartureToNextDepartureResponseConverter getConverter() {
		return converter;
	}

	public void setConverter(NextDepartureToNextDepartureResponseConverter converter) {
		this.converter = converter;
	}
}
