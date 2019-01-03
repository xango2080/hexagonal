package com.xango2080.domain.model;

import java.util.Objects;

public class Train {

	private String code;

	private String mission;

	public Train(String code, String mission) {
		this.code = code;
		this.mission = mission;
	}

	public String getCode() {
		return code;
	}

	public String getMission() {
		return mission;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Train train = (Train) o;
		return Objects.equals(getCode(), train.getCode()) &&
			   Objects.equals(getMission(), train.getMission());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCode(), getMission());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Train{");
		sb.append("code='").append(code).append('\'');
		sb.append(", mission='").append(mission).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
