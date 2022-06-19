package softuni.exam.models.dto.offer;

import softuni.exam.models.dto.IdDto;
import softuni.exam.models.dto.NameDto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDto {
    @Positive
    private BigDecimal price;

    private NameDto agent;

    private IdDto apartment;

    private String publishedOn;

    public BigDecimal getPrice() {
        return price;
    }

    public NameDto getAgent() {
        return agent;
    }

    public IdDto getApartment() {
        return apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }
}
