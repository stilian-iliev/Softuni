package xml.entities.category;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryStatsDto {
    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "products-count")
    private long count;

    @XmlElement(name = "average-price")
    private double averagePrice;

    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public CategoryStatsDto() {
    }

    public CategoryStatsDto(String name, long count, double averagePrice, BigDecimal totalRevenue) {
        this.name = name;
        this.count = count;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }


}
