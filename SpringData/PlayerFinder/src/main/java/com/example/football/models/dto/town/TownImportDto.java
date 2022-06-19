package com.example.football.models.dto.town;

public class TownImportDto {
    private String name;
    private int population;
    private String travelGuide;

    public TownImportDto(String name, int population, String travelGuide) {
        this.name = name;
        this.population = population;
        this.travelGuide = travelGuide;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public boolean isValid() {
        if (getName().length() < 2) return false;
        if (getPopulation() <= 0) return false;
        if (getTravelGuide().length() < 10) return false;

        return true;
    }
}
