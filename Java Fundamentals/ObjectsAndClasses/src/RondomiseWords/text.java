package RondomiseWords;

import java.util.Random;

public class text {
    private String[] string;

    public void setString(String[] string) {
        this.string = string;
    }
    public void randomise(){
        Random rnd = new Random();
        for (int i = 0; i < string.length; i++) {
            String temp = string[i];
            int randomIndex = rnd.nextInt(string.length);
            string[i] = string[randomIndex];
            string[randomIndex] = temp;
        }
        for (String s : string) {
            System.out.println(s);
        }
    }
}
