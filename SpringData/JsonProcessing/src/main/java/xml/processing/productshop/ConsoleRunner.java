package xml.processing.productshop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import xml.processing.productshop.repositories.CategoryRepository;
import xml.processing.productshop.services.ProductService;
import xml.processing.productshop.services.SeedService;
import xml.processing.productshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryRepository categoryRepository;

    private Gson gson;

    @Autowired
    public ConsoleRunner(SeedService seedService, ProductService productService, UserService userService, CategoryRepository categoryRepository) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void run(String... args) throws Exception {
//        seedService.seedAll();
        seedService.seedUsers();


    }
}
