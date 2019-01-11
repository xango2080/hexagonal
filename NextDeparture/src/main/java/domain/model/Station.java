package domain.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Station {

	private String label;
	private List<Disruption> disruptions;
	public static final Station NULL = new Station(null, Collections.emptyList());

	public Station(String label, List<Disruption> disruptions) {
		this.label = label;
		this.disruptions = disruptions;
	}

	public String getLabel() {
		return label;
	}

	public List<Disruption> getDisruptions() {
		return disruptions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Station station = (Station) o;
		return Objects.equals(getLabel(), station.getLabel()) &&
			   Objects.equals(getDisruptions(), station.getDisruptions());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLabel(), getDisruptions());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Station{");
		sb.append("label='").append(label).append('\'');
		sb.append(", disruptions=").append(disruptions);
		sb.append('}');
		return sb.toString();
	}
}
