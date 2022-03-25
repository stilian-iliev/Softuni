import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder password = new StringBuilder(sc.nextLine());
        String[] command = sc.nextLine().split(" ");
        while (!command[0].equals("Done")){
            switch (command[0]){
                case "TakeOdd":
                    StringBuilder temp = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if(i%2==1){
                            temp.append(password.charAt(i));
                        }
                    }
                    password = temp;
                    System.out.println(password.toString());
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    password.delete(index,index+length);
                    System.out.println(password.toString());
                    break;
                case "Substitute":
                    String substring = command[1];
                    String substitute = command[2];
                    if (password.toString().contains(substring)){
                        password = new StringBuilder(password.toString().replace(substring,substitute));
                        System.out.println(password.toString());
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            command = sc.nextLine().split(" ");
        }
        System.out.printf("Your password is: %s%n",password.toString());
    }
}
