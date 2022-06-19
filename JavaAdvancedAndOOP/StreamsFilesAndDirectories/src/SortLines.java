import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);
        PrintStream out = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\sort-lines.txt");
        out.print(String.join(System.lineSeparator(), lines));
    }
}
