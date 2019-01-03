package com.xango2080.app.usecase.departure.dto;

import java.io.Serializable;

public class TrainDTO implements Serializable {

	private String code;

	private String mission;

	public TrainDTO(String code, String mission) {
		this.code = code;
		this.mission = mission;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}
}
