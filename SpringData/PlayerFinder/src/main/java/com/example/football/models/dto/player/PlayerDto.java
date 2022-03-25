package com.example.football.models.dto.player;

import com.example.football.models.entity.enums.PlayerPosition;

public class PlayerDto {
    private String firstName;
    private String lastName;
    private PlayerPosition position;
    private String teamName;
    private String stadiumName;


    public PlayerDto(String firstName, String lastName, PlayerPosition position, String teamName, String stadiumName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.teamName = teamName;
        this.stadiumName = stadiumName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    @Override
    public String toString() {
        return String.format("Player - %s %s\n" +
                "\tPosition - %s\n" +
                "\tTeam - %s\n" +
                "\tStadium - %s", getFirstName(), getLastName(), getPosition().name(), getTeamName(), getStadiumName());
    }
}
