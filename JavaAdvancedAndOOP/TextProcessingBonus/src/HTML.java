import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder article = new StringBuilder();
        String title = sc.nextLine();
        String content = sc.nextLine();
        article.append("<h1>\n");
        article.append("    "+title);
        article.append("\n</h1>\n");
        article.append("<article>\n");
        article.append("    "+content);
        article.append("\n</article>\n");
        String comments = sc.nextLine();
        while (!comments.equals("end of comments")){
            article.append("<div>\n");
            article.append("    "+comments);
            article.append("\n</div>\n");
            comments = sc.nextLine();
        }
        System.out.println(article.toString());
    }
}
