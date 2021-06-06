import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\every-third-line2.txt");
        Path path = Paths.get("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        List<String> list = Files.readAllLines(path);
        for (int i = 2; i < list.size(); i+=3) {
            out.println(list.get(i));
        }
    }
}
