package com.nighthawk.spring_portfolio.mvc.astronomy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CelestialData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private double distanceKm;
    private double distanceAu;
    private double altitudeDegrees;
    private double azimuthDegrees;
    private String constellationShort;
    private String constellationName;
    private String constellationId;
    private double rightAscensionHours;
    private String rightAscensionString;
    private String declinationString;
    private double declinationDegrees;
    private double magnitude;
    private String elongation;

    public CelestialData() {
        // default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public double getDistanceAu() {
        return distanceAu;
    }

    public void setDistanceAu(double distanceAu) {
        this.distanceAu = distanceAu;
    }

    public double getAltitudeDegrees() {
        return altitudeDegrees;
    }

    public void setAltitudeDegrees(double altitudeDegrees) {
        this.altitudeDegrees = altitudeDegrees;
    }

    public double getAzimuthDegrees() {
        return azimuthDegrees;
    }

    public void setAzimuthDegrees(double azimuthDegrees) {
        this.azimuthDegrees = azimuthDegrees;
    }

    public String getConstellationShort() {
        return constellationShort;
    }

    public void setConstellationShort(String constellationShort) {
        this.constellationShort = constellationShort;
    }

    public String getConstellationName() {
        return constellationName;
    }

    public void setConstellationName(String constellationName) {
        this.constellationName = constellationName;
    }

    public String getConstellationId() {
        return constellationId;
    }

    public void setConstellationId(String constellationId) {
        this.constellationId = constellationId;
    }

    public double getRightAscensionHours() {
        return rightAscensionHours;
    }

    public void setRightAscensionHours(double rightAscensionHours) {
        this.rightAscensionHours = rightAscensionHours;
    }

    public String getRightAscensionString() {
        return rightAscensionString;
    }

    public void setRightAscensionString(String rightAscensionString) {
        this.rightAscensionString = rightAscensionString;
    }

    public String getDeclinationString() {
        return declinationString;
    }

    public void setDeclinationString(String declinationString) {
        this.declinationString = declinationString;
    }

    public double getDeclinationDegrees() {
        return declinationDegrees;
    }

    public void setDeclinationDegrees(double declinationDegrees) {
        this.declinationDegrees = declinationDegrees;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getElongation() {
        return elongation;
    }

    public void setElongation(String elongation) {
        this.elongation = elongation;
    }
}