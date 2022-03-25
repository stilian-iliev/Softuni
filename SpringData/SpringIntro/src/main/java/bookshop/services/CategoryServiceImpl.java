package bookshop.services;

import bookshop.models.Category;
import bookshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        int size = (int) categoryRepository.count();
        int catSize = new Random().nextInt(size);

        Set<Integer> ids = new HashSet<>();
        for (int i = 0; i < catSize; i++) {
            int id = new Random().nextInt(size)+1;
            ids.add(id);
        }
        return new HashSet<>(categoryRepository.findAllById(ids));
    }
}
