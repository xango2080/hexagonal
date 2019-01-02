package domain.model;

public class Train {

	private String code;

	private String mission;

	Train(String code, String mission) {
		this.code = code;
		this.mission = mission;
	}

	public String getCode() {
		return code;
	}

	public String getMission() {
		return mission;
	}
}
