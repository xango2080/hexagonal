package com.xango.nextdeparture.domain.model;

import com.xango.nextdeparture.annotation.ddd.ValueObject;

import java.time.LocalDateTime;

@ValueObject
public class Disruption {

	private final String title;
	private final LocalDateTime date;

	public Disruption(String title, LocalDateTime date) {
		this.title = title;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public LocalDateTime getDate() {
		return date;
	}

}
