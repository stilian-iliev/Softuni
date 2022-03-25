public class Vowels {

    public static int getCount(String str) {
        int vowelsCount = 0;
//        return (int)str.toLowerCase().chars().filter(c-> String.valueOf(c).matches("[aeiou]")).count();
        for (char c : str.toCharArray()) {
            switch (c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelsCount++;
                    break;
            }
        }
        return vowelsCount;
    }

}