import java.io.File;
import java.util.Objects;

public class FileSize {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        int sum = 0;
        for (File s : Objects.requireNonNull(file.listFiles())) {
            sum += s.length();
        }
        System.out.printf("Folder size: %d%n",sum );
    }
}
