import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(file);
        int count = 1;
        System.out.println(dirs.peek());
        while (!dirs.isEmpty()) {
            File[] files = dirs.poll().listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println(f.getName());
                    dirs.offer(f);
                    count++;
                }
            }
        }
        System.out.println(count+ " folders");
    }
}
