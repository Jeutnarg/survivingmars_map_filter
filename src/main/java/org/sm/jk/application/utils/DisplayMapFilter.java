package org.sm.jk.application.utils;

import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import org.sm.jk.application.model.DisplayMap;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DisplayMapFilter {
    private boolean useAdvancedBreakthrough;
    private AdvancedBreakthroughPredicate advancedBreakthroughPredicate;
    private AdvancedBreakthroughPredicate breakthroughPredicate;
    private Set<String> breakthroughsPlus  = new HashSet<>();
    private Set<String> breakthroughsMinus  = new HashSet<>();
    private Set<String> threatDustDevils = new HashSet<>();
    private Set<String> threatDustStorms = new HashSet<>();
    private Set<String> threatMeteorShowers = new HashSet<>();
    private Set<String> threatColdWaves = new HashSet<>();
    private Set<String> resourceMetals = new HashSet<>();
    private Set<String> resourceRareMetals = new HashSet<>();
    private Set<String> resourceConcrete = new HashSet<>();
    private Set<String> resourceWater = new HashSet<>();
    private Set<String> topographies  = new HashSet<>();
    private Set<String> mapTypes  = new HashSet<>();
    private Set<String> locations  = new HashSet<>();

    public ListChangeListener<String> genBreakthroughPlusListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                breakthroughsPlus.addAll(change.getAddedSubList());
                breakthroughsPlus.removeAll(change.getRemoved());
            }
            if(!useAdvancedBreakthrough)
                displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<String> genBreakthroughMinusListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                breakthroughsMinus.addAll(change.getAddedSubList());
                breakthroughsMinus.removeAll(change.getRemoved());
            }
            if(!useAdvancedBreakthrough)
                displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<Integer> genThreatDustDevilsListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                threatDustDevils.addAll(change.getAddedSubList().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
                threatDustDevils.removeAll(change.getRemoved().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<Integer> genThreatDustStormsListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                threatDustStorms.addAll(change.getAddedSubList().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
                threatDustStorms.removeAll(change.getRemoved().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<Integer> genThreatMeteorShowersListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                threatMeteorShowers.addAll(change.getAddedSubList().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
                threatMeteorShowers.removeAll(change.getRemoved().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<Integer> genThreatColdWavesListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                threatColdWaves.addAll(change.getAddedSubList().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
                threatColdWaves.removeAll(change.getRemoved().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<Integer> genResourceMetalsListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                resourceMetals.addAll(change.getAddedSubList().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
                resourceMetals.removeAll(change.getRemoved().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<Integer> genResourceRareMetalsListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                resourceRareMetals.addAll(change.getAddedSubList().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
                resourceRareMetals.removeAll(change.getRemoved().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<Integer> genResourceConcreteListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                resourceConcrete.addAll(change.getAddedSubList().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
                resourceConcrete.removeAll(change.getRemoved().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<Integer> genResourceWaterListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                resourceWater.addAll(change.getAddedSubList().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
                resourceWater.removeAll(change.getRemoved().stream().map(i -> Integer.toString(i)).collect(Collectors.toList()));
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<String> genTopographyListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                topographies.addAll(change.getAddedSubList());
                topographies.removeAll(change.getRemoved());
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<String> genMapTypeListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                mapTypes.addAll(change.getAddedSubList());
                mapTypes.removeAll(change.getRemoved());
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public ListChangeListener<String> genLocationListener(FilteredList<DisplayMap> displayMapFilteredList) {
        return change -> {
            while(change.next()) {
                locations.addAll(change.getAddedSubList());
                locations.removeAll(change.getRemoved());
            }
            displayMapFilteredList.setPredicate(new DisplayPredicate());
        };
    }

    public void updateAdvancedBreakthrough(AdvancedBreakthroughPredicate advancedBreakthroughPredicate) {
        this.advancedBreakthroughPredicate = advancedBreakthroughPredicate;
    }

    public void setAdvancedMode(boolean selected) {
        this.useAdvancedBreakthrough = selected;
    }

    private class DisplayPredicate implements Predicate<DisplayMap> {
        @Override
        public boolean test(DisplayMap map) {

            if(!useAdvancedBreakthrough) {
                if(!breakthroughsPlus.isEmpty()) {
                    for(String breakthroughName : breakthroughsPlus) {
                        if(!map.getBreakthroughs().contains(breakthroughName)) {
                            return false;
                        }
                    }
                }
                if(!breakthroughsMinus.isEmpty()) {
                    for(String breakthroughName : breakthroughsMinus) {
                        if(map.getBreakthroughs().contains(breakthroughName)) {
                            return false;
                        }
                    }
                }
            } else {
                if(!advancedBreakthroughPredicate.test(map))
                    return false;
            }

            if(!topographies.isEmpty()) {
                boolean match = false;
                for(String topography : topographies) {
                    if(topography.equals(map.getTopography())) {
                        match = true;
                    }
                }
                if(!match) {
                    return false;
                }
            }
            if(!mapTypes.isEmpty()) {
                boolean match = false;
                for(String mapType : mapTypes) {
                    if(mapType.equals(map.getMapType())) {
                        match = true;
                    }
                }
                if(!match) {
                    return false;
                }
            }
            if(!locations.isEmpty()) {
                boolean match = false;
                for(String location : locations) {
                    if(location.equals(map.getLocation())) {
                        match = true;
                    }
                }
                if(!match) {
                    return false;
                }
            }
            if(!threatDustDevils.isEmpty()) {
                String dustDevil = map.getThreats().substring(2,3);
                if(!threatDustDevils.contains(dustDevil)) {
                    return false;
                }
            }
            if(!threatDustStorms.isEmpty()) {
                String dustStorm = map.getThreats().substring(5,6);
                if(!threatDustStorms.contains(dustStorm)) {
                    return false;
                }
            }
            if(!threatMeteorShowers.isEmpty()) {
                String meteorStorms = map.getThreats().substring(8,9);
                if(!threatMeteorShowers.contains(meteorStorms)) {
                    return false;
                }
            }
            if(!threatColdWaves.isEmpty()) {
                String coldWaves = map.getThreats().substring(11,12);
                if(!threatColdWaves.contains(coldWaves)) {
                    return false;
                }
            }
            if(!resourceMetals.isEmpty()) {
                String metal = map.getResources().substring(1,2);
                if(!resourceMetals.contains(metal)) {
                    return false;
                }
            }
            if(!resourceRareMetals.isEmpty()) {
                String rareMetal = map.getResources().substring(3,4);
                if(!resourceRareMetals.contains(rareMetal)) {
                    return false;
                }
            }
            if(!resourceConcrete.isEmpty()) {
                String concrete = map.getResources().substring(5,6);
                if(!resourceConcrete.contains(concrete)) {
                    return false;
                }
            }
            if(!resourceWater.isEmpty()) {
                String water = map.getResources().substring(7,8);
                if(!resourceWater.contains(water)) {
                    return false;
                }
            }
            return true;
        }
    }
}
