package xml.processing.productshop.entities.product;

import java.math.BigDecimal;

public class SellableProductsDto {
    private String name;
    private BigDecimal price;
    private String seller;

    public SellableProductsDto(String name, BigDecimal price, String sellerFirstName, String sellerLastName) {
        this.name = name;
        this.price = price;
        this.seller = sellerFirstName == null ? sellerLastName : sellerFirstName + " " + sellerLastName;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSeller() {
        return seller;
    }
}
