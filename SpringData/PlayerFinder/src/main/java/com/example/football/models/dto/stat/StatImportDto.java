package com.example.football.models.dto.stat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class StatImportDto {
    @XmlElement
    private float passing;

    @XmlElement
    private float shooting;

    @XmlElement
    private float endurance;

    public StatImportDto() {
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }

    public float getPassing() {
        return passing;
    }

    public float getShooting() {
        return shooting;
    }

    public float getEndurance() {
        return endurance;
    }

    public boolean isValid() {
        if (getPassing() <= 0) return false;
        if (getShooting() <= 0) return false;
        if (getEndurance() <= 0) return false;
        return true;
    }
}
