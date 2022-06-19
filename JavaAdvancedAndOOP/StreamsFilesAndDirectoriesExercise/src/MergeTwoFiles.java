import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        PrintStream out = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\merged-files.txt");
        writeFile(reader,out);
        reader = new BufferedReader(new FileReader("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
        writeFile(reader,out);

    }

    private static void writeFile(BufferedReader reader, PrintStream out) throws IOException {
        String line = reader.readLine();
        while (line != null){
            out.println(line);
            line = reader.readLine();
        }
    }
}
