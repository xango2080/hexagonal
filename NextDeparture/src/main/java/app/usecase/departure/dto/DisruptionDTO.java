package app.usecase.departure.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DisruptionDTO implements Serializable {

	private LocalDateTime date;

	private String title;

	public DisruptionDTO(LocalDateTime date, String title) {
		this.date = date;
		this.title = title;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
