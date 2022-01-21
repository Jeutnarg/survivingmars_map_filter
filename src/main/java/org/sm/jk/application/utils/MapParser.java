package org.sm.jk.application.utils;

import org.sm.jk.application.model.Map;

public class MapParser {

    public static Map parse(String line) {
        String[] parts = line.split(",");
        Map result = new Map();
        int counter = 0;
        result.setLatitude(Integer.parseInt(parts[counter++]));
        result.setLatitudeCompass(parts[counter++]);
        result.setLongitude(Integer.parseInt(parts[counter++]));
        result.setLongitudeCompass(parts[counter++]);
        result.setTopography(parts[counter++]);
        result.setDifficulty(Integer.parseInt(parts[counter++]));
        result.setAltitude(Integer.parseInt(parts[counter++]));
        result.setTemperature(Integer.parseInt(parts[counter++]));
        result.setMetals(Integer.parseInt(parts[counter++]));
        if(parts[counter].isEmpty()) {
            result.setRareMetals(result.getMetals());
            counter++;
        }
        else {
            result.setRareMetals(Integer.parseInt(parts[counter++]));
        }
        result.setConcrete(Integer.parseInt(parts[counter++]));
        result.setWater(Integer.parseInt(parts[counter++]));
        result.setDustDevils(Integer.parseInt(parts[counter++]));
        result.setDustStorms(Integer.parseInt(parts[counter++]));
        result.setMeteors(Integer.parseInt(parts[counter++]));
        result.setColdWave(Integer.parseInt(parts[counter++]));
        result.setMapName(parts[counter++]);
        result.setNamedLocation(parts[counter++]);
        for(int i = 0; i < 17; i++) {
            result.addBreakthrough(BreakthroughParser.parse(parts[counter++]));
        }
        return result;
    }
}
