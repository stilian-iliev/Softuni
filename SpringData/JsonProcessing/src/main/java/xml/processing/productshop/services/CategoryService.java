package xml.processing.productshop.services;

import xml.processing.productshop.entities.category.CategoryStatisticsDto;

import java.util.List;

public interface CategoryService {
    List<CategoryStatisticsDto> findCategoriesStatistics();
}
