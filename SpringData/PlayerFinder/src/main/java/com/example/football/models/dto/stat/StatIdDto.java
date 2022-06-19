package com.example.football.models.dto.stat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class StatIdDto {
    @XmlElement
    private int id;

    public StatIdDto() {
    }

    public int getId() {
        return id;
    }
}
