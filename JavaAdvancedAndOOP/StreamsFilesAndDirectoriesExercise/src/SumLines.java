import java.io.*;
import java.util.Arrays;

public class SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new FileReader("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        String n = sc.readLine();
        while (n != null){
            int sum = 0;
            for (int i = 0; i < n.length(); i++) {
                sum+= n.charAt(i);
            }
            System.out.println(sum);
            n = sc.readLine();
        }
    }
}
