package exam.model.town;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TownImportDto {
    @XmlElement
    private String name;

    @XmlElement
    private int population;

    @XmlElement(name = "travel-guide")
    private String travelGuide;

    public TownImportDto() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setTravelGuide(String travelGuide) {
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

    public boolean validate() {
        if (getName().length() < 2) {
            return false;
        }
        if (getPopulation() < 1) {
            return false;
        }
        if (getTravelGuide().length() < 10) {
            return false;
        }
        return true;
    }
}
