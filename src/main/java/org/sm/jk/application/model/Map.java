package org.sm.jk.application.model;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int latitude, longitude;
    private String latitudeCompass, longitudeCompass;
    private String topography;
    private int difficulty;
    private int altitude;
    private int temperature;
    private int metals;
    private int rareMetals;
    private int concrete;
    private int water;
    private int dustDevils;
    private int dustStorms;
    private int meteors;
    private int coldWave;
    private String mapName;
    private String namedLocation;
    private List<Breakthrough> breakthroughs;

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getLatitudeCompass() {
        return latitudeCompass;
    }

    public void setLatitudeCompass(String latitudeCompass) {
        this.latitudeCompass = latitudeCompass;
    }

    public String getLongitudeCompass() {
        return longitudeCompass;
    }

    public void setLongitudeCompass(String longitudeCompass) {
        this.longitudeCompass = longitudeCompass;
    }

    public String getTopography() {
        return topography;
    }

    public void setTopography(String topography) {
        this.topography = topography;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getMetals() {
        return metals;
    }

    public void setMetals(int metals) {
        this.metals = metals;
    }

    public int getRareMetals() {
        return rareMetals;
    }

    public void setRareMetals(int rareMetals) {
        this.rareMetals = rareMetals;
    }

    public int getConcrete() {
        return concrete;
    }

    public void setConcrete(int concrete) {
        this.concrete = concrete;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getDustDevils() {
        return dustDevils;
    }

    public void setDustDevils(int dustDevils) {
        this.dustDevils = dustDevils;
    }

    public int getDustStorms() {
        return dustStorms;
    }

    public void setDustStorms(int dustStorms) {
        this.dustStorms = dustStorms;
    }

    public int getMeteors() {
        return meteors;
    }

    public void setMeteors(int meteors) {
        this.meteors = meteors;
    }

    public int getColdWave() {
        return coldWave;
    }

    public void setColdWave(int coldWave) {
        this.coldWave = coldWave;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getNamedLocation() {
        return namedLocation;
    }

    public void setNamedLocation(String namedLocation) {
        this.namedLocation = namedLocation;
    }

    public List<Breakthrough> getBreakthroughs() {
        return breakthroughs;
    }

    public void addBreakthrough(Breakthrough breakthrough) {
        if(breakthroughs == null) {
            breakthroughs = new ArrayList<>(17);
        }
        breakthroughs.add(breakthrough);
    }

    public void setBreakthroughs(List<Breakthrough> breakthroughs) {
        this.breakthroughs = breakthroughs;
    }
}
