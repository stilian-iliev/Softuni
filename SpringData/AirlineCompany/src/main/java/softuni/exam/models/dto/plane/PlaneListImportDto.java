package softuni.exam.models.dto.plane;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneListImportDto {
    @XmlElement(name = "plane")
    private List<PlaneImportDto> planes;

    public PlaneListImportDto() {
    }

    public List<PlaneImportDto> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlaneImportDto> planes) {
        this.planes = planes;
    }
}
