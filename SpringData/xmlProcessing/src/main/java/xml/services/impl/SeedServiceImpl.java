package xml.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.entities.category.Category;
import xml.entities.category.CategoryListImportDto;
import xml.entities.product.Product;
import xml.entities.product.ProductsListImportDto;
import xml.entities.user.User;
import xml.entities.user.UsersListImportDto;
import xml.repositories.CategoryRepository;
import xml.repositories.ProductRepository;
import xml.repositories.UserRepository;
import xml.services.SeedService;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {
    private final Gson gson;
    private final String USERS_XML_PATH = "src\\main\\resources\\files\\users.xml";
    private final String PRODUCTS_XML_PATH = "src\\main\\resources\\files\\products.xml";
    private final String CATEGORIES_XML_PATH = "src\\main\\resources\\files\\categories.xml";

    private JAXBContext context;
    private Unmarshaller unmarshaller;
    private ModelMapper mapper;

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) throws JAXBException {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.gson = new Gson();
        mapper = new ModelMapper();
    }

    @Override
    public void seedUsers() throws FileNotFoundException, JAXBException {
        context = JAXBContext.newInstance(UsersListImportDto.class);
        unmarshaller = context.createUnmarshaller();

        UsersListImportDto importDto = (UsersListImportDto) unmarshaller.unmarshal(new FileReader(USERS_XML_PATH));

        List<User> users = importDto.getUsers()
                .stream().map(u -> mapper.map(u, User.class))
                .collect(Collectors.toList());

        userRepository.saveAll(users);

    }

    @Override
    @Transactional
    public void seedProducts() throws FileNotFoundException, JAXBException {
        context = JAXBContext.newInstance(ProductsListImportDto.class);
        unmarshaller = context.createUnmarshaller();

        ProductsListImportDto importDto = (ProductsListImportDto)unmarshaller.unmarshal(new FileReader(PRODUCTS_XML_PATH));

        List<Product> products = importDto.getProducts()
                .stream().map(p -> mapper.map(p, Product.class))
                .map(p -> {
                    p.setBuyer(getRandomUser(true));
                    p.setSeller(getRandomUser(false));
                    p.setCategories(getRandomCategories());
                    return p;
                }).collect(Collectors.toList());

        productRepository.saveAll(products);

    }

    private Set<Category> getRandomCategories() {
        int size = new Random().nextInt((int) categoryRepository.count() + 1);
        Set<Integer> ids = new HashSet<>();
        for (int i = 0; i < size; i++) {
            ids.add(new Random().nextInt((int) categoryRepository.count()) + 1);
        }
        return new HashSet<>(categoryRepository.findAllById(ids));
    }

    private User getRandomUser(boolean nullable) {
        long size = userRepository.count();


        int id = new Random().nextInt((int)size) +1 ;

        return nullable && new Random().nextInt() % 2 == 0 ? null : userRepository.getById(id);
    }

    @Override
    public void seedCategories() throws FileNotFoundException, JAXBException {
        context = JAXBContext.newInstance(CategoryListImportDto.class);
        unmarshaller = context.createUnmarshaller();
        FileReader xmlReader = new FileReader(CATEGORIES_XML_PATH);
        CategoryListImportDto importDTO = (CategoryListImportDto) unmarshaller.unmarshal(xmlReader);

        List<Category> categories = importDTO.getCategories()
                .stream().map(c -> mapper.map(c, Category.class))
                .collect(Collectors.toList());

        categoryRepository.saveAll(categories);
    }
}
