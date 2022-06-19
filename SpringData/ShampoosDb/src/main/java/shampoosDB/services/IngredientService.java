package shampoosDB.services;

import shampoosDB.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> selectStartingWith(String s);

    List<Ingredient> orderByPrice(List<String> ingredientNames);

    int deleteByName(String name);

    int increasePriceByTenPercent();
}
