import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStream = new FileInputStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        PrintStream output = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt");
        int nextByte = fileStream.read();
        while (nextByte != -1){
            output.print(Integer.toBinaryString(nextByte)+" ");
            nextByte = fileStream.read();
        }
    }
}
