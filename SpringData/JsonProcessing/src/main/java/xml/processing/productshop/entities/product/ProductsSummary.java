package xml.processing.productshop.entities.product;

import java.util.List;

public class ProductsSummary {
    private long count;
    private List<ProductSummary> products;

    public long getCount() {
        return count;
    }

    public List<ProductSummary> getProducts() {
        return products;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setProducts(List<ProductSummary> products) {
        this.count = products.size();
        this.products = products;
    }
}
