package exam.model.shop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopListImportDto {
    @XmlElement(name = "shop")
    private List<ShopImportDto> shops;

    public ShopListImportDto() {
    }

    public List<ShopImportDto> getShops() {
        return shops;
    }

    public void setShops(List<ShopImportDto> shops) {
        this.shops = shops;
    }
}
