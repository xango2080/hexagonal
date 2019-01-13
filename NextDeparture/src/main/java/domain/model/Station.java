package domain.model;

import annotation.ddd.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Station {

    public static final Station NULL = new Station(null, Collections.emptyList());
    private StationId stationId;
    private final String label;
    private final List<Disruption> disruptions;

    Station(String label, List<Disruption> disruptions) {
        this.label = label;
        this.disruptions = disruptions;
        this.stationId = StationId.newStationId();
    }

    public static Builder builder(){
        return new Station.Builder();
    }

    public String getLabel() {
        return label;
    }

    public List<Disruption> getDisruptions() {
        return disruptions;
    }

    public StationId getId(){
        return stationId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(stationId, station.stationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationId);
    }

    @annotation.ddd.Builder
    public static class Builder {

        private  String label;
        private  List<Disruption> disruptions = new ArrayList<>();

        public Builder withLabel(String label){
            this.label = label;
            return this;
        }

        public Builder addDisruption(Disruption disruption){
            this.disruptions.add(disruption);
            return this;
        }

        public Station builder() {
            return new Station(label, disruptions);
        }

    }
}
