package bg.softuni.battleships.services;

import bg.softuni.battleships.models.Category;
import bg.softuni.battleships.models.enums.ShipType;
import bg.softuni.battleships.reposiotories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void seed() {
        List<Category> categories = Arrays.stream(ShipType.values())
                .map(Category::new)
                .filter(e -> !categoryRepository.existsByName(e.getName()))
                .collect(Collectors.toList());
        categoryRepository.saveAll(categories);



    }
}
