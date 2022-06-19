import java.util.Scanner;

public class RhombusWithStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String rhombus = makeRhombus(1,n);
        System.out.println(rhombus);
    }

    private static String makeRhombus(int stars ,int n) {
        StringBuilder rhombus = new StringBuilder();
        int spaces = n-1;
        rhombus.append(" ".repeat(spaces));
        rhombus.append("* ".repeat(stars));
        rhombus.append(System.lineSeparator());
        if (spaces==0) return rhombus.toString();
        rhombus.append(makeRhombus(stars+1,spaces));
        rhombus.append(" ".repeat(spaces));
        rhombus.append("* ".repeat(stars));
        if (stars!=1)
        rhombus.append(System.lineSeparator());
        return rhombus.toString();
    }
}
