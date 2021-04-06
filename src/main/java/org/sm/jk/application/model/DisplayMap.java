package org.sm.jk.application.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.List;
import java.util.stream.Collectors;

public class DisplayMap {
    private SimpleStringProperty coordinates;
    private SimpleStringProperty topography;
    private SimpleIntegerProperty altitude;
    private SimpleIntegerProperty temperature;
    private SimpleStringProperty mapType;
    private SimpleStringProperty location;
    private SimpleStringProperty resources;
    private SimpleStringProperty threats;
    private SimpleIntegerProperty difficulty;
    private final List<String> breakthroughs;

    public DisplayMap(Map map) {
        coordinates = new SimpleStringProperty(map.getLatitude()+map.getLatitudeCompass()+map.getLongitude()+map.getLongitudeCompass());
        topography = new SimpleStringProperty(map.getTopography());
        altitude = new SimpleIntegerProperty(map.getAltitude());
        temperature = new SimpleIntegerProperty(map.getTemperature());
        mapType = new SimpleStringProperty(map.getMapName());
        location = new SimpleStringProperty(map.getNamedLocation());
        resources = new SimpleStringProperty("M"+map.getMetals()+"R"+map.getRareMetals()+"C"+map.getConcrete()+"W"+map.getWater());
        threats = new SimpleStringProperty("DD"+map.getDustDevils()+"DS"+map.getDustStorms()+"MS"+map.getMeteors()+"CW"+map.getColdWave());
        difficulty = new SimpleIntegerProperty(map.getDifficulty());
        this.breakthroughs = map.getBreakthroughs().stream().map(b -> b.getName()).collect(Collectors.toList());
    }

    //for testing
    public DisplayMap(List<String> breakthroughs) {
        this.breakthroughs = breakthroughs;
    }

    public String getCoordinates() {
        return coordinates.get();
    }

    public SimpleStringProperty coordinatesProperty() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates.set(coordinates);
    }

    public String getTopography() {
        return topography.get();
    }

    public SimpleStringProperty topographyProperty() {
        return topography;
    }

    public void setTopography(String topography) {
        this.topography.set(topography);
    }

    public int getAltitude() {
        return altitude.get();
    }

    public SimpleIntegerProperty altitudeProperty() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude.set(altitude);
    }

    public int getTemperature() {
        return temperature.get();
    }

    public SimpleIntegerProperty temperatureProperty() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature.set(temperature);
    }

    public String getMapType() {
        return mapType.get();
    }

    public SimpleStringProperty mapTypeProperty() {
        return mapType;
    }

    public void setMapType(String mapType) {
        this.mapType.set(mapType);
    }

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getResources() {
        return resources.get();
    }

    public SimpleStringProperty resourcesProperty() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources.set(resources);
    }

    public String getThreats() {
        return threats.get();
    }

    public SimpleStringProperty threatsProperty() {
        return threats;
    }

    public void setThreats(String threats) {
        this.threats.set(threats);
    }

    public int getDifficulty() {
        return difficulty.get();
    }

    public SimpleIntegerProperty difficultyProperty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty.set(difficulty);
    }

    public List<String> getBreakthroughs() {
        return breakthroughs;
    }
}
