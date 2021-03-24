import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Articles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Article> articlesList = new ArrayList<>();
        String[] constructors = sc.nextLine().split(", ");
        Article article = new Article(constructors[0], constructors[1], constructors[2]);
        articlesList.add(article);
        for (int i = 1; i < n; i++) {
            constructors = sc.nextLine().split(", ");
            article = new Article(constructors[0], constructors[1], constructors[2]);
            articlesList.add(article);
        }
        String sorter = sc.nextLine();

        if (sorter.equals("title")) {
            articlesList.sort(Comparator.comparing(Article::getTitle));
            sortAndPrnt(articlesList);
        } else if (sorter.equals("content")) {
            articlesList.sort(Comparator.comparing(Article::getContent));
            sortAndPrnt(articlesList);
        } else {
            articlesList.sort(Comparator.comparing(Article::getAuthor));
            sortAndPrnt(articlesList);
        }

    }

    public static void sortAndPrnt(List<Article> list) {
        for (Article article : list) {
            System.out.println(article.toString());
        }
    }
}

class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.author = author;
        this.content = content;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void rename(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void edit(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void changeAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " - " + content + ": " + author;
    }
}
