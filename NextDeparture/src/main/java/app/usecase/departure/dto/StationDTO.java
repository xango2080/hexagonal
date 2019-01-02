package app.usecase.departure.dto;

import java.io.Serializable;
import java.util.Collection;

public class StationDTO implements Serializable {

	private String label;

	private Collection<DisruptionDTO> disruptions;

	public StationDTO(String label, Collection<DisruptionDTO> disruptions) {

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Collection<DisruptionDTO> getDisruptions() {
		return disruptions;
	}

	public void setDisruptions(Collection<DisruptionDTO> disruptions) {
		this.disruptions = disruptions;
	}
}
