package xml.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.entities.product.ProductsInRangeDto;
import xml.entities.product.ProductsXmlWrapper;
import xml.repositories.ProductRepository;
import xml.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
        mapper = new ModelMapper();
    }

    @Override
    public ProductsXmlWrapper findAllInRange(double low, double high) {
        List<ProductsInRangeDto> productsDtos = productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(low), BigDecimal.valueOf(high));
        return new ProductsXmlWrapper(productsDtos);
    }
}
