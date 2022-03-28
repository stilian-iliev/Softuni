package softuni.exam.models.dto.ticket;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImportDto {
    @XmlElement(name = "serial-number")
    @Size(min = 2)
    private String serialNumber;

    @XmlElement
    @Positive
    private BigDecimal price;

    @XmlElement(name = "take-off")
    @NotNull
    private String takeoff;

    @XmlElement(name = "from-town")
    private TownNameDto fromTown;

    @XmlElement(name = "to-town")
    private TownNameDto toTown;

    @XmlElement
    private PassengerEmailDto passenger;

    @XmlElement
    private PlaneNumberDto plane;

    public String getSerialNumber() {
        return serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public TownNameDto getFromTown() {
        return fromTown;
    }

    public TownNameDto getToTown() {
        return toTown;
    }

    public PassengerEmailDto getPassenger() {
        return passenger;
    }

    public PlaneNumberDto getPlane() {
        return plane;
    }
}
