package domain.model;

import annotation.ddd.Builder;
import annotation.ddd.Entity;

import java.util.Objects;

@Entity
public class Train {

    private final TrainId trainId;
    private final String code;
    private final String mission;

    public Train(String code, String mission) {
        this.code = code;
        this.mission = mission;
        this.trainId = TrainId.newTrainId();
    }

    public String getCode() {
        return code;
    }

    public String getMission() {
        return mission;
    }

    public TrainId getId(){
        return trainId;
    }

    public static Train.Builder builder(){
        return new Train.Builder();
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

    @annotation.ddd.Builder
    public static class Builder {

        private String code;
        private String mission;

        Builder(){

        }

        public Builder withCode(String code){
            this.code = code;
            return this;
        }

        public Builder withMission(String mission){
            this.mission = mission;
            return this;
        }


        public Train builder() {
            return new Train(code, mission);
        }

    }
}
