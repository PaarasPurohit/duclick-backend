package com.nighthawk.spring_portfolio.mvc.astronomy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CelestialData {
    @JsonProperty("data")
    private CelestialDataInfo data;

    @Data
    public static class CelestialDataInfo {
        private Observer observer;
        private Dates dates;
        private Table table;
    }

    @Data
    public static class Observer {
        private Location location;
    }

    @Data
    public static class Location {
        private double longitude;
        private double elevation;
        private double latitude;
    }

    @Data
    public static class Dates {
        private String from;
        private String to;
    }

    @Data
    public static class Table {
        private List<Row> rows;
    }

    @Data
    public static class Row {
        private List<Cell> cells;
        private Entry entry;
    }

    @Data
    public static class Cell {
        private String date;
        private Distance distance;
        private Position position;
        private String name;
        private ExtraInfo extraInfo;
        private String id; // Use String for id
    }

    @Data
    public static class Distance {
        @JsonProperty("fromEarth")
        private FromEarth fromEarth;
    }

    @Data
    public static class FromEarth {
        private String km;
        private String au;
    }

    @Data
    public static class Position {
        private Horizontal horizontalPosition;
        private Azimuth azimuth;
        private Constellation constellation;
        private Equatorial equatorial;
    }

    @Data
    public static class Horizontal {
        private String altitude;
    }

    @Data
    public static class Azimuth {
        private String azimuth;
    }

    @Data
    public static class Constellation {
        @JsonProperty("short")
        private String shortName;
        private String name;
    }

    @Data
    public static class Equatorial {
        @JsonProperty("rightAscensionString")
        private String rightAscensionString;
        private String declinationString;
    }

    @Data
    public static class ExtraInfo {
        private String magnitude;
        private String elongation;
        private String distanceKm;
    }

    @Data
    public static class Entry {
        private String name;
        private String id;
    }
}
