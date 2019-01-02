package domain.model;

public class Station {
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Station)) {
			return false;
		}

		Station station = (Station) o;

		return getLabel() != null ? getLabel().equals(station.getLabel()) : station.getLabel() == null;
	}

	@Override
	public int hashCode() {
		return getLabel() != null ? getLabel().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Station{" +
				"label='" + label + '\'' +
				'}';
	}
}
