import java.util.*;
import java.util.stream.Collectors;

public class Heroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> heroHealth = new LinkedHashMap<>();
        Map<String, Integer> heroMana = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            int health = Integer.parseInt(input[1]);
            int mana = Integer.parseInt(input[2]);
            if (mana <= 200 && health <= 100) {
                heroHealth.put(name, health);
                heroMana.put(name, mana);
            }
        }
        String[] command = sc.nextLine().split(" - ");
        while (!command[0].equals("End")) {
            switch (command[0]) {
                case "CastSpell":
                    castASpell(heroMana, command);
                    break;
                case "TakeDamage":
                    takeDamage(heroHealth, command, heroMana);
                    break;
                case "Recharge":
                    recharge(command, heroMana);
                    break;
                case "Heal":
                    heal(command, heroHealth);
                    break;
            }
            command = sc.nextLine().split(" - ");
        }

        Map<String, Integer> result = heroHealth.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()).thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> set : result.entrySet()) {
            System.out.println(set.getKey());
            System.out.println("  HP: " + set.getValue());
            System.out.println("  MP: " + heroMana.get(set.getKey()));

        }
    }

    private static void heal(String[] command, Map<String, Integer> heroHealth) {
        String hero = command[1];
        int heal = Integer.parseInt(command[2]);
        heroHealth.put(hero, heroHealth.get(hero) + heal);
        if (heroHealth.get(hero) > 100) {
            int excess = heroHealth.get(hero) - 100;
            heal -= excess;
            heroHealth.put(hero, 100);
        }
        System.out.printf("%s healed for %d HP!%n", hero, heal);
    }

    private static void recharge(String[] command, Map<String, Integer> heroMana) {
        String hero = command[1];
        int mana = Integer.parseInt(command[2]);
        heroMana.put(hero, heroMana.get(hero) + mana);
        if (heroMana.get(hero) > 200) {
            int excess = heroMana.get(hero) - 200;
            heroMana.put(hero, 200);
            mana -= excess;
        }
        System.out.printf("%s recharged for %d MP!%n", hero, mana);
    }

    private static void takeDamage(Map<String, Integer> heroHealth, String[] command, Map<String, Integer> heroMana) {
        String hero = command[1];
        int damage = Integer.parseInt(command[2]);
        String attacker = command[3];
        heroHealth.put(hero, heroHealth.get(hero) - damage);
        if (heroHealth.get(hero) > 0) {
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", hero, damage, attacker, heroHealth.get(hero));
        } else {
            heroHealth.remove(hero);
            heroMana.remove(hero);
            System.out.printf("%s has been killed by %s!%n", hero, attacker);
        }
    }

    private static void castASpell(Map<String, Integer> heroMana, String[] command) {
        String hero = command[1];
        int manaNeeded = Integer.parseInt(command[2]);
        String spellName = command[3];
        if (heroMana.get(hero) - manaNeeded > 0) {
            heroMana.put(hero, heroMana.get(hero) - manaNeeded);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", hero, spellName, heroMana.get(hero));
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", hero, spellName);
        }
    }
}
