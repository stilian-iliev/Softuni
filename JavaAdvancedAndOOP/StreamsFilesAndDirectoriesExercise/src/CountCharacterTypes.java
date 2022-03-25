import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        PrintStream out = new PrintStream("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\character-types-count.txt");

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        String in = reader.readLine();
        while (in != null) {
            for (char c : in.toCharArray()) {
                switch (c) {
                    case ' ':
                        break;
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowels++;
                        break;
                    case '?':
                    case ',':
                    case '!':
                    case '.':
                        punctuation++;
                        break;
                    default:
                        consonants++;
                        break;
                }
            }
            in = reader.readLine();
        }
        out.printf("Vowels: %d%n",vowels);
        out.printf("Consonants: %d%n",consonants);
        out.printf("Punctuation: %d%n",punctuation);
    }
}
