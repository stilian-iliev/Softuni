package Google;

public class Child {
    private String name;
    private String birthday;

    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public String toString(){
        return String.format("%n%s %s",name,birthday);
    }
}
