package bg.softuni.coffeeshop.seeders;

import bg.softuni.coffeeshop.models.Category;
import bg.softuni.coffeeshop.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategorySeeder implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<Category> categories = new ArrayList<>();
            categories.add(new Category("Drink", 1));
            categories.add(new Category("Coffee", 2));
            categories.add(new Category("Other", 5));
            categories.add(new Category("Cake", 10));

            categoryRepository.saveAll(categories);
        }
    }
}
