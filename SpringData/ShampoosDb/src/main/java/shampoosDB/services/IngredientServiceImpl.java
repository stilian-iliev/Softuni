package shampoosDB.services;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shampoosDB.entities.Ingredient;
import shampoosDB.repositories.IngredientRepository;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectStartingWith(String s) {
        return ingredientRepository.findAllByNameStartingWith(s);
    }

    @Override
    public List<Ingredient> orderByPrice(List<String> ingredientNames) {
        return ingredientRepository.findAllByNameInOrderByPrice(ingredientNames);
    }

    @Transactional
    @Modifying
    @Override
    public int deleteByName(String name) {
        return ingredientRepository.deleteByName(name);
    }

    @Transactional
    @Modifying
    @Override
    public int increasePriceByTenPercent() {
        return ingredientRepository.increasePriceByTenPercent();
    }
}
