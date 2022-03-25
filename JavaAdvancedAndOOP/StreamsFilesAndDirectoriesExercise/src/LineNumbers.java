import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        PrintStream out = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\line-numbers.txt");
        int counter = 1;
        String line = reader.readLine();
        while (line != null){
            out.println(counter + ". " + line);
            counter++;
            line = reader.readLine();
        }
    }
}
