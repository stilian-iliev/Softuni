import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStream = new FileInputStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        PrintStream output = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\copy-bytes.txt");
        int nextChar = fileStream.read();
        while (nextChar != -1 ){
            switch (nextChar){
                case 10:
                case 32:
                    output.print((char) nextChar);
                    break;
                default:
                    output.print(nextChar);
                    break;
            }
            nextChar = fileStream.read();
        }
    }
}
