package TheGarden;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Character>> garden = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());

        int moleRow = 0, moleCol = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            garden.add(new ArrayList<>());
            for (String s : input) {
                garden.get(i).add(s.charAt(0));
            }
//            if (input.contains("M")){
//                moleRow = i;
//                moleCol = input.indexOf("M");
//            }
        }

        int carrots = 0, potatoes = 0, lettuce = 0;
        int harmed = 0;

        String input = sc.nextLine();
        while (!input.equals("End of Harvest")) {
            String[] inputArr = input.split("\\s+");
            String command = inputArr[0];
            int row = Integer.parseInt(inputArr[1]);
            int col = Integer.parseInt(inputArr[2]);
            if (!valid(row, col, garden)) {
                input = sc.nextLine();
                continue;
            }
            switch (command) {
                case "Harvest":
                    switch (garden.get(row).get(col)) {
                        case 'C':
                            carrots++;
                            break;
                        case 'P':
                            potatoes++;
                            break;
                        case 'L':
                            lettuce++;
                            break;
                    }
                    garden.get(row).set(col, ' ');
                    break;
                case "Mole":
                    String direction = inputArr[3];
                    while (valid(row, col, garden)) {
                        if (garden.get(row).get(col) != ' '){
                            harmed++;
                            garden.get(row).set(col, ' ');
                        }
                        switch (direction) {
                            case "up":
                                row -= 2;
                                break;
                            case "down":
                                row += 2;
                                break;
                            case "left":
                                col -= 2;
                                break;
                            case "right":
                                col += 2;
                                break;
                        }
                    }
                    break;
            }
            input = sc.nextLine();
        }
        printMatrix(garden);

        System.out.println("Carrots: "+ carrots);
        System.out.println("Potatoes: "+ potatoes);
        System.out.println("Lettuce: "+ lettuce);
        System.out.println("Harmed vegetables: "+ harmed);
    }

    private static void printMatrix(List<List<Character>> garden) {
        for (List<Character> characters : garden) {
            for (Character character : characters) {
                System.out.print(character +" ");
            }
            System.out.println();
        }
    }

    private static boolean valid(int row, int col, List<List<Character>> garden) {
        return row >= 0 && row < garden.size() && col >= 0 && col < garden.get(row).size();
    }
}
