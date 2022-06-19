package guild;

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz){
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getClazz() {
        return clazz;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return String.format("Player %s: %s%n" +
                "Rank: %s%n" +
                "Description: %s",name,clazz,rank,description);
    }
}
