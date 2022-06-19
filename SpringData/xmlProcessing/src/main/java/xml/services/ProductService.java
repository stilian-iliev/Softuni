package xml.services;

import xml.entities.product.ProductsXmlWrapper;

public interface ProductService {

    ProductsXmlWrapper findAllInRange(double low, double high);
}
