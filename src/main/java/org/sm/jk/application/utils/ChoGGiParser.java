package org.sm.jk.application.utils;

import org.sm.jk.application.model.Breakthrough;
import org.sm.jk.application.model.DisplayMap;
import org.sm.jk.application.model.Map;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ChoGGiParser {

    private List<Map> maps = new ArrayList<>();
    private Set<String> topographies = new HashSet<>(10);
    private Set<String> mapTypes = new HashSet<>();
    private Set<String> locations = new HashSet<>();
    private Set<String> breakthroughs = new HashSet<>();

    public List<Map> getMaps() {
        return maps;
    }

    public Set<String> getTopographies() {
        return topographies;
    }

    public Set<String> getMapTypes() {
        return mapTypes;
    }

    public Set<String> getLocations() {
        return locations;
    }

    public Set<String> getBreakthroughs() {
        return breakthroughs;
    }

    public void parse(File fileToParse) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileToParse))) {
            br.readLine();//column names - skip until we ever get to the point of reading them
            String line = null;
            while((line = br.readLine()) != null) {
                Map map = MapParser.parse(line);
                maps.add(map);
                if(map.getTopography() != null && !map.getTopography().isEmpty())
                    topographies.add(map.getTopography());
                if(map.getMapName() != null && !map.getMapName().isEmpty())
                    mapTypes.add(map.getMapName());
                if(map.getNamedLocation() != null && !map.getNamedLocation().isEmpty())
                    locations.add(map.getNamedLocation());
                if(map.getBreakthroughs() != null) {
                    for(Breakthrough breakthrough : map.getBreakthroughs()) {
                        breakthroughs.add(breakthrough.getName());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<DisplayMap> getDisplayMaps() {
        return maps.stream().map(map -> new DisplayMap(map)).collect(Collectors.toList());
    }
}
