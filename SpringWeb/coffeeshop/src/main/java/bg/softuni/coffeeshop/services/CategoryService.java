package bg.softuni.coffeeshop.services;

import bg.softuni.coffeeshop.models.Category;
import bg.softuni.coffeeshop.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category findById(UUID uuid) {
        return categoryRepository.findById(uuid).get();
    }
}
