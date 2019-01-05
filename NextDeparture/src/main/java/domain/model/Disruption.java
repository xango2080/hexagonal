package domain.model;

import java.time.LocalDateTime;

public class Disruption {

	private String title;

	private LocalDateTime date;

	public Disruption(String title, LocalDateTime date) {
		this.title = title;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
