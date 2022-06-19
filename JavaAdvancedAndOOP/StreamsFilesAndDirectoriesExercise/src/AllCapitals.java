import java.io.*;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        PrintStream print = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\all-capital.txt");
        String line = reader.readLine();
        while (line != null){
            print.println(line.toUpperCase(Locale.ROOT));
            line = reader.readLine();
        }
    }
}
