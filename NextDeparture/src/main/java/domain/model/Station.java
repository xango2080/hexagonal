package domain.model;

import java.util.List;

public class Station {
	private String label;

	private List<Disruption> disruptions;

	Station(String label, List<Disruption> disruptions) {
		this.label = label;
		this.disruptions = disruptions;
	}

	public String getLabel() {
		return label;
	}

	public List<Disruption> getDisruptions() {
		return disruptions;
	}
}
