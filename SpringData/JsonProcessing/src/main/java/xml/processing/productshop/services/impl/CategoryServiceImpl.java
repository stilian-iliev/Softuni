package xml.processing.productshop.services.impl;

import xml.processing.productshop.entities.category.CategoryStatisticsDto;
import xml.processing.productshop.repositories.CategoryRepository;
import xml.processing.productshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryStatisticsDto> findCategoriesStatistics() {
        return categoryRepository.findAllCategoryStatistics();
    }
}
