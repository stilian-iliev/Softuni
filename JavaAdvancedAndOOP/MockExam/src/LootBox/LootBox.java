package LootBox;

import java.util.*;

public class LootBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] firstRow = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i : firstRow) {
            queue.offer(i);
        }

        int[] secondRow = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i : secondRow) {
            stack.push(i);
        }
        List<Integer> loot = new ArrayList<>();

        while (!queue.isEmpty() && !stack.isEmpty()) {
            if ((queue.peek() + stack.peek()) % 2 == 0) {
                loot.add(queue.poll() + stack.pop());
            } else {
                queue.offer(stack.pop());
            }
        }
        if (stack.isEmpty()) System.out.println("Second lootbox is empty");
        else System.out.println("First lootbox is empty");

        int sum = loot.stream().mapToInt(e -> e).sum();

        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }
    }
}
