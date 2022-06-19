package xml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xml.entities.category.CategoriesListDto;
import xml.entities.product.ProductsXmlWrapper;
import xml.entities.user.UsersProductsCountListDto;
import xml.entities.user.UsersWithSoldProductsListDto;
import xml.repositories.CategoryRepository;
import xml.services.CategoryService;
import xml.services.ProductService;
import xml.services.SeedService;
import xml.services.UserService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;

    private Gson gson;

    @Autowired
    public ConsoleRunner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void run(String... args) throws Exception {
//        seedService.seedAll();

//        1
//        JAXBContext context = JAXBContext.newInstance(ProductsXmlWrapper.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//        ProductsXmlWrapper allInRange = productService.findAllInRange(500, 1000);
//
//        marshaller.marshal(allInRange, System.out);

//        2
//        JAXBContext context = JAXBContext.newInstance(UsersWithSoldProductsListDto.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//        UsersWithSoldProductsListDto usersWithSoldProductsList = userService.findAllWithSoldProducts();
//
//        marshaller.marshal(usersWithSoldProductsList, System.out);

//        3
//        JAXBContext context = JAXBContext.newInstance(CategoriesListDto.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//        CategoriesListDto categoriesListDto = categoryService.findCategoryStatistics();
//
//        marshaller.marshal(categoriesListDto, System.out);

//        4
        JAXBContext context = JAXBContext.newInstance(UsersProductsCountListDto.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        UsersProductsCountListDto usersProductsCountListDto = userService.findAllUsersProductsCount();

        marshaller.marshal(usersProductsCountListDto, System.out);


    }
}
