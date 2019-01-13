package app.rest;

import domain.model.NextDeparture;

import java.util.Collections;
import java.util.Set;

public class TransilienNextDeparture {

    private final String station;
    private final String hour;
    private final String name;
    private final String type;
    private final String partner;
    private final Destination destination;
    private final Set<String> disruptions;


    public TransilienNextDeparture(NextDeparture nextDeparture) {
        this.hour = null;
        this.station = null;
        this.name = null;
        this.type = "train";
        this.partner = "sncf";
        this.destination = null;
        this.disruptions = Collections.emptySet();
    }

    public String getStation() {
        return station;
    }

    public String getHour() {
        return hour;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPartner() {
        return partner;
    }

    public Destination getDestination() {
        return destination;
    }

    public Set<String> getDisruptions() {
        return disruptions;
    }

    class Destination {

        private final String from;
        private final String to;

        Destination(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }
    }
}
