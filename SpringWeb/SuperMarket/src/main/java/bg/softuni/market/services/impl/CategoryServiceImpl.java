package bg.softuni.market.services.impl;

import bg.softuni.market.models.entities.Category;
import bg.softuni.market.repositories.CategoryRepository;
import bg.softuni.market.services.CategoryService;
import bg.softuni.market.utils.InvalidArgumentException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addCategory(String name) {
        Optional<Category> byName = categoryRepository.findByName(name);
        if (byName.isPresent()) {
            throw new InvalidArgumentException("Category already exists!");
        }
        categoryRepository.save(new Category(name));
        System.out.println("Successfully added category!");
    }
}
