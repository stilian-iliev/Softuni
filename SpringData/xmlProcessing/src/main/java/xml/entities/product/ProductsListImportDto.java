package xml.entities.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsListImportDto {
    @XmlElement(name = "product")
    private List<ProductImportDto> products;

    public ProductsListImportDto() {}

    public List<ProductImportDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductImportDto> products) {
        this.products = products;
    }
}
