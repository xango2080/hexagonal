package com.xango.nextdeparture.domain.model;

import com.xango.nextdeparture.annotation.ddd.ValueObject;

import java.util.Objects;
import java.util.UUID;

@ValueObject
public class StationId {

    private UUID uuid;

    StationId(UUID uuid) {
        this.uuid = uuid;
    }

    public static StationId newStationId(){
        return new StationId(UUID.randomUUID());
    }

    public UUID value() {
        return this.uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationId stationId = (StationId) o;
        return Objects.equals(uuid, stationId.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StationId{");
        sb.append("uuid=").append(uuid);
        sb.append('}');
        return sb.toString();
    }
}
