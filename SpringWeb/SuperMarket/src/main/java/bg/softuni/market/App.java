package bg.softuni.market;

import bg.softuni.market.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class App implements CommandLineRunner {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final SellerService sellerService;
    private final ShopService shopService;
    private final TownService townService;

    public App(CategoryService categoryService, ProductService productService, SellerService sellerService, ShopService shopService, TownService townService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.sellerService = sellerService;
        this.shopService = shopService;
        this.townService = townService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi!");
        printMenu();
        String in = sc.nextLine();
        String[] ins;
        while (!in.equals("0")) {
            try {
                switch (in) {
                    case "1":
                        System.out.println("Enter category name:");
                        in = sc.nextLine();
                        categoryService.addCategory(in);
                        break;
                    case "2":
                        System.out.println("Enter town name:");
                        in = sc.nextLine();
                        townService.addTown(in);
                        break;
                    case "3":
                        System.out.println("Enter shop details in format: name address town");
                        in = sc.nextLine();
                        ins = in.split(" ");
                        shopService.addShop(ins[0], ins[1], ins[2]);
                        break;
                    case "4":
                        System.out.println("Enter seller details in format: firstName lastName age salary shopName");
                        ins = in.split(" ");
                        sellerService.addSeller(ins[0], ins[1], Integer.parseInt(ins[2]), new BigDecimal(ins[3]), ins[4]);
                        break;
                    case "5":
                        System.out.println("Enter product details in format: name price bestBefore(dd-MM-yyyy) category");
                        ins = in.split(" ");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate date = LocalDate.parse(ins[2], formatter);
                        productService.addProduct(ins[0], new BigDecimal(ins[1]), date, ins[3]);
                        break;
                    case "6":
                        System.out.println("Enter seller first and last names:");
                        String[] seller = sc.nextLine().split(" ");
                        System.out.println("Enter seller manager and last names:");
                        ins = sc.nextLine().split(" ");
                        sellerService.setNewManager(seller[0], seller[1], ins[0], ins[1]);
                        break;
                    case "7":
                        System.out.println("Enter product name");
                        in = sc.nextLine();
                        System.out.println("Enter product distribution in Shops names in format [shopName1 shopName2 ... ]");
                        ins = sc.nextLine().split(" ");
                        productService.distributeProduct(in, ins);
                        break;
                    case "8":
                        System.out.println("Enter shop name:");
                        in = sc.nextLine();
                        shopService.showAllSellers(in);
                        break;
                    case "9":
                        System.out.println("Enter shop name:");
                        in = sc.nextLine();
                        shopService.showAllProducts(in);
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            printMenu();
            in = sc.nextLine();
        }
    }

    public void printMenu() {
        System.out.println("""
                Choose options from:
                1 - for Add Category
                2 - for Add Town
                3 - for Add Shop
                4 - for Add Seller
                5 - for Add Product
                6 - for Set seller new manager
                7 - for Distributing product to shops
                8 - for Showing all sellers in Shop
                9 - for Showing all products in Shop
                0 - for Exit""");
    }
}
