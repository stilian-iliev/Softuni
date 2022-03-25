import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStream = new FileInputStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        PrintStream output = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt");
        Set<Character> blacklist = new HashSet<>(Set.of('?','.',',','!'));
        int curr = fileStream.read();
        while (curr  > -1){
            if (!blacklist.contains((char)curr)){
                output.print((char)curr);
            }
            curr = fileStream.read();
        }
    }
}
