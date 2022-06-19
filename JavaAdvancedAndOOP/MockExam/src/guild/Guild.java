package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) roster.add(player);
    }

    public boolean removePlayer(String name) {
        Player player = roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);
        if (player != null) {
            roster.remove(player);
            return true;
        } else return false;
    }

    public void promotePlayer(String name) {
        roster.stream()
                .filter(p -> p.getName().equals(name))
                .limit(1)
                .forEach(p -> p.setRank("Member"));
    }

    public void demotePlayer(String name) {
        roster.stream()
                .filter(p -> p.getName().equals(name))
                .limit(1)
                .forEach(p -> p.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] players = roster.stream()
                .filter(p -> p.getClazz().equals(clazz))
                .toArray(Player[]::new);
        for (Player player : players) {
            roster.remove(player);
        }
        return players;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        return String.format("Players in the guild: %s:%n%s"
                , name
                , roster.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
