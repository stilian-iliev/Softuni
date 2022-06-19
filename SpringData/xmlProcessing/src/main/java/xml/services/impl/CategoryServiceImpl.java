package xml.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.entities.category.CategoriesListDto;
import xml.entities.category.CategoryStatsDto;
import xml.repositories.CategoryRepository;
import xml.services.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoriesListDto findCategoryStatistics() {
        List<CategoryStatsDto> categoryStats = categoryRepository.findAllCategoryStatsOrderByProductCount();

        return new CategoriesListDto(categoryStats);
    }
}
