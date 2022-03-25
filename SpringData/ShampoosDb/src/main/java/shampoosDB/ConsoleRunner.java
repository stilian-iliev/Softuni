package shampoosDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import shampoosDB.entities.Shampoo;
import shampoosDB.services.IngredientService;
import shampoosDB.services.ShampooService;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println(ingredientService.increasePriceByTenPercent());
    }
}
