package xml.processing.productshop.services.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.processing.productshop.entities.category.Category;
import xml.processing.productshop.entities.product.Product;
import xml.processing.productshop.entities.user.User;
import xml.processing.productshop.repositories.CategoryRepository;
import xml.processing.productshop.repositories.ProductRepository;
import xml.processing.productshop.repositories.UserRepository;
import xml.processing.productshop.services.SeedService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class SeedServiceImpl implements SeedService {
    private final Gson gson;
    private final String USERS_XML_PATH = "src\\main\\resources\\files\\users.xml";
    private final String PRODUCTS_XML_PATH = "src\\main\\resources\\files\\products.xml";
    private final String CATEGORIES_XML_PATH = "src\\main\\resources\\files\\categories.xml";

    private JAXBContext context;
    private Unmarshaller unmarshaller;

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) throws JAXBException {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.gson = new Gson();
    }

    @Override
    public void seedUsers() throws FileNotFoundException, JAXBException {
        context = JAXBContext.newInstance(User.class);
        unmarshaller = context.createUnmarshaller();
        User[] users = (User[]) unmarshaller.unmarshal(new FileReader(USERS_XML_PATH));
        userRepository.saveAll(Arrays.asList(users));

    }

    @Override
    public void seedProducts() throws FileNotFoundException, JAXBException {
        context = JAXBContext.newInstance(Product.class);
        unmarshaller = context.createUnmarshaller();


    }

    private Set<Category> getRandomCategories() {
        int size = new Random().nextInt((int) categoryRepository.count() + 1);
        Set<Integer> ids = new HashSet<>();
        for (int i = 0; i < size; i++) {
            ids.add(new Random().nextInt((int) categoryRepository.count()) + 1);
        }
        return new HashSet<>(categoryRepository.findAllById(ids));
    }

    @Override
    public void seedCategories() throws FileNotFoundException, JAXBException {
        context = JAXBContext.newInstance(Category.class);
        unmarshaller = context.createUnmarshaller();

    }
}
