package xml.processing.productshop.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import xml.processing.productshop.entities.product.SellableProductsDto;
import xml.processing.productshop.repositories.ProductRepository;
import xml.processing.productshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public String findSellableDtoJsonByPriceBetween(BigDecimal low, BigDecimal high) {
        List<SellableProductsDto> productsDtos = productRepository.findAllByBuyerNullAndPriceBetweenOrderByPriceAsc(low, high);
        return gson.toJson(productsDtos);
    }
}
