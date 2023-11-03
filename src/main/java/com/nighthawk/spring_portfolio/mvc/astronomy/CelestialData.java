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
    private String id;

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
        private Row entry;
    }

    @Data
    public static class Row {
        private List<Cell> cells;
    }

    @Data
    public static class Cell {
        private String date;
        private Distance distance;
        private Position position;
        private String name;
        private ExtraInfo extraInfo;
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
        private Horizontal horizontal;
        private Azimuth azimuth;
        private Constellation constellation;
        private Equatorial equatorial;
    }

    @Data
    public static class Horizontal {
        private Altitude altitude;
    }

    @Data
    public static class Altitude {
        @JsonProperty("string")
        private String stringValue;
        private String degrees;
    }

    @Data
    public static class Azimuth {
        private String azimuth;
        private String degrees;
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
}