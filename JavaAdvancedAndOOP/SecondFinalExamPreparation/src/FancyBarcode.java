import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String barcode = sc.nextLine();
            StringBuilder group = new StringBuilder();
            Pattern barcodeRegex = Pattern.compile("(@#+)([A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)");
            Matcher barcodeMatcher = barcodeRegex.matcher(barcode);
            if (barcodeMatcher.find()){
                Pattern digit = Pattern.compile("[0-9]");
                Matcher digitMatcher = digit.matcher(barcode);
                while (digitMatcher.find()){
                    group.append(digitMatcher.group());
                }
                if(group.length()==0){
                    group.append("00");
                }
                System.out.println("Product group: " + group.toString());
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
