package shampoosDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shampoosDB.entities.Shampoo;
import shampoosDB.entities.Size;
import shampoosDB.repositories.ShampooRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> selectBySize(Size size) {
        return shampooRepository.findAllBySize(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabelId(Size size, Long id) {
        return shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size, id);
    }

    @Override
    public List<Shampoo> selectMoreExpensiveThan(BigDecimal price) {
        return shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Long selectCheaperThan(BigDecimal price) {
        return shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> selectByIngredients(List<String> ingredients) {
        return shampooRepository.findAllDistinctByIngredientsNameIn(ingredients);
    }

    @Override
    public List<Shampoo> selectWhereIngredientsCountLessThan(int size) {
        return shampooRepository.findAllWithIngredientsCountLessThan(size);
    }


}
