import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));
        PrintStream out = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\extract-integers.txt");

        while (sc.hasNext()){
            if (sc.hasNextInt()){
                out.println(sc.nextInt());
            }
            sc.next();
        }
    }
}
