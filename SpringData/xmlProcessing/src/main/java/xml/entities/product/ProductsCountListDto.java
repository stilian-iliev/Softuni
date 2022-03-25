package xml.entities.product;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsCountListDto {
    @XmlAttribute(name = "count")
    private int count;

    @XmlElement(name = "product")
    private List<ProductAttributeDto> products;

    public ProductsCountListDto() {
    }

    public void setProducts(List<ProductAttributeDto> products) {
        this.products = products;
        count = products.size();
    }
}
