import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        StringBuilder decrypted = new StringBuilder();
        for (String morseLetter : input) {
            String letter = "";
            switch (morseLetter) {
                case ".-":
                    letter = "A";
                    break;
                case "-...":
                    letter = "B";
                    break;
                case "-.-.":
                    letter = "C";
                    break;
                case "-..":
                    letter = "D";
                    break;
                case ".":
                    letter = "E";
                    break;
                case "..-.":
                    letter = "F";
                    break;
                case "--.":
                    letter = "G";
                    break;
                case "....":
                    letter = "H";
                    break;
                case "..":
                    letter = "I";
                    break;
                case ".---":
                    letter = "J";
                    break;
                case "-.-":
                    letter = "K";
                    break;
                case ".-..":
                    letter = "L";
                    break;
                case "--":
                    letter = "M";
                    break;
                case "-.":
                    letter = "N";
                    break;
                case "---":
                    letter = "O";
                    break;
                case ".--.":
                    letter = "P";
                    break;
                case "--.-":
                    letter = "Q";
                    break;
                case ".-.":
                    letter = "R";
                    break;
                case "...":
                    letter = "S";
                    break;
                case "-":
                    letter = "T";
                    break;
                case "..-":
                    letter = "U";
                    break;
                case "...-":
                    letter = "V";
                    break;
                case ".--":
                    letter = "W";
                    break;
                case "-..-":
                    letter = "X";
                    break;
                case "-.--":
                    letter = "Y";
                    break;
                case "--..":
                    letter = "Z";
                    break;
                default:
                    letter = " ";
                    break;
            }
            decrypted.append(letter);
        }
        System.out.println(decrypted.toString());
    }
}
