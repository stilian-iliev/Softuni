package com.example.football.models.dto.player;

import com.example.football.models.dto.stat.StatIdDto;
import com.example.football.models.dto.team.TeamNameDto;
import com.example.football.models.dto.town.TownNameDto;
import com.example.football.models.entity.enums.PlayerPosition;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImportDto {
    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElement
    private String email;

    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement
    private String position;

    @XmlElement(name = "town")
    private TownNameDto townName;

    @XmlElement(name = "team")
    private TeamNameDto teamName;

    @XmlElement(name = "stat")
    private StatIdDto statId;

    public PlayerImportDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPosition() {
        return position;
    }

    public TownNameDto getTownName() {
        return townName;
    }

    public TeamNameDto getTeamName() {
        return teamName;
    }

    public StatIdDto getStatId() {
        return statId;
    }

    public boolean isValid() {
        if (getFirstName().length() <= 2) return false;
        if (getLastName().length() <= 2) return false;
        if (!getEmail().contains("@") || !getEmail().contains(".")) return false;
        for (PlayerPosition value : PlayerPosition.values()) {
            if (value.name().equals(getPosition())) return true;
        }
        return false;
    }
}
