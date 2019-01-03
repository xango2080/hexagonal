package com.xango2080.domain.model;

import java.time.LocalDateTime;

public class Disruption {

	private final String title;

	private final LocalDateTime date;

	Disruption(String title, LocalDateTime date) {
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
