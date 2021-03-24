import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pathway = sc.nextLine().split("\\\\");
        String[] file = pathway[pathway.length-1].split("\\.");
        String fileName = file[0];
        String extension = file[1];
        System.out.printf("File name: %s%nFile extension: %s",fileName,extension);
    }
}
