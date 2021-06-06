import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        int sum = 0;
        String n = reader.readLine();
        while (n != null){
            for (char c : n.toCharArray()) {
                sum += c;
            }
            n = reader.readLine();
        }
        System.out.println(sum);
    }
}
