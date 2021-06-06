import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()){
                System.out.printf("%s: [%d]%n",f.getName(), f.length());
            }
        }
    }
}
