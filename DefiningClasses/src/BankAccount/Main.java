package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String command = input.split("\\s+")[0];
            String output = null;
            switch (command) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    output = String.format("Account ID%d created", account.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(input.split("\\s+")[1]);
                    double amount = Double.parseDouble(input.split("\\s+")[2]);
                    if (accounts.containsKey(id)) {
                        accounts.get(id).deposit(amount);
                        output = String.format("Deposited %.0f to ID%d", amount, id);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(input.split("\\s+")[1]);
                    BankAccount.setInterest(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(input.split("\\s+")[1]);
                    if (accounts.containsKey(id)) {
                        int years = Integer.parseInt(input.split("\\s+")[2]);
                        output = String.format("%.2f", accounts.get(id).getInterest(years));
                    } else {
                        output = "Account does not exist";
                    }
                    break;
            }
            if (output != null) {
                System.out.println(output);
            }
            input = sc.nextLine();
        }
    }
}
