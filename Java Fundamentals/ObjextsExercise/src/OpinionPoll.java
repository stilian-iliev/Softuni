import java.util.*;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<People> peopleList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            People person = new People(input[0],Integer.parseInt(input[1]));
            peopleList.add(person);
        }
        peopleList.sort(Comparator.comparing(People::getName));
        for (People people : peopleList) {
            if (people.getAge()>30){
                System.out.printf("%s - %d%n",people.getName(),people.getAge());
            }
        }
    }
}

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
