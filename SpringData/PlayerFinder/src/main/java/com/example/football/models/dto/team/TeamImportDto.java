package com.example.football.models.dto.team;

public class TeamImportDto {
    private String name;
    private String stadiumName;
    private int fanBase;
    private String history;
    private String townName;

    public TeamImportDto(String name, String stadiumName, int fanBase, String history, String townName) {
        this.name = name;
        this.stadiumName = stadiumName;
        this.fanBase = fanBase;
        this.history = history;
        this.townName = townName;
    }

    public String getName() {
        return name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public int getFanBase() {
        return fanBase;
    }

    public String getHistory() {
        return history;
    }

    public String getTownName() {
        return townName;
    }

    public boolean isValid() {
        if (getName().length() < 3) return false;
        if (getStadiumName().length() < 3) return false;
        if (getFanBase() < 1000) return false;
        if (getHistory().length() < 10) return false;
        return true;
    }
}
