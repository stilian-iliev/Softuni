package bookshop_exercise;

import bookshop_exercise.service.AuthorService;
import bookshop_exercise.service.BookService;
import bookshop_exercise.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        1
//        AgeRestriction ageRestriction = AgeRestriction.valueOf(sc.nextLine().toUpperCase());
//        bookService.printAllTitlesWithAgeRestriction(ageRestriction);

//        2
//        bookService.printAllTitlesByEditionAndLessThanCopies(EditionType.GOLD, 5000);

//        3
//        bookService.printTitleAndPriceWithPriceNotBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(40));

//        4
//        int year = Integer.parseInt(sc.nextLine());
//        bookService.printTitlesWhereYearNot(year);

//        5
//        LocalDate date = LocalDate.parse (sc.nextLine(),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        bookService.printBooksBeforeDate(date);

//        6
//        String endsWith = sc.nextLine();
//        authorService.printAllAuthorsFirstNamesStartingWith(endsWith);

//        7
//        String subStr = sc.nextLine();
//        bookService.printAllTitlesContainingSubstr(subStr);

//        8
//        String startingWith = sc.nextLine();
//        bookService.printTitlesOfAuthorsStartingWith(startingWith);

//        9
//        int n = Integer.parseInt(sc.nextLine());
//        bookService.printCountOfBooksWhoseTitleLongerThan(n);

//        10
//        authorService.printAllBookCopies();

//        11
//        String bookTitle = sc.nextLine();
//        bookService.printBookSummary(bookTitle);

//        12
//        LocalDate date = LocalDate.parse(sc.nextLine(),DateTimeFormatter.ofPattern("dd MMM yyyy"));
//        int amount = Integer.parseInt(sc.nextLine());
//        bookService.increaseCopiesOfBooksAfterDate(amount, date);

//        13
//        int threshold = Integer.parseInt(sc.nextLine());
//        bookService.deleteBooksWithCopiesLessThan(threshold);

//        14
//        String name = sc.nextLine();
//        authorService.printBooksCountByName(name);

    }


}
