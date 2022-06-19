package xml.processing.productshop.services;

import java.math.BigDecimal;

public interface ProductService {
    String findSellableDtoJsonByPriceBetween(BigDecimal low, BigDecimal high);
}
