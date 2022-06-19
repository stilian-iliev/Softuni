package shampoosDB.services;

import shampoosDB.entities.Shampoo;
import shampoosDB.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> selectBySize(Size size);
    List<Shampoo> selectBySizeOrLabelId(Size size, Long id);
    List<Shampoo> selectMoreExpensiveThan(BigDecimal price);
    Long selectCheaperThan(BigDecimal price);
    List<Shampoo> selectByIngredients(List<String> ingredients);
    List<Shampoo> selectWhereIngredientsCountLessThan(int size);

}
