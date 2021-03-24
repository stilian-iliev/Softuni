import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        List<Peoples> peoplesList = new ArrayList<>();
        while (!input[0].equals("End")){
            Peoples person = new Peoples(input[0],Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            peoplesList.add(person);
            input = sc.nextLine().split("\\s+");
        }
        peoplesList = peoplesList.stream().sorted(Comparator.comparing(Peoples::getAge)).collect(Collectors.toList());
        for (Peoples peoples : peoplesList) {
            System.out.println(peoples.toString());
        }
    }
}
class Peoples{
    private String name;
    private int id;

    public int getAge() {
        return age;
    }

    private int age;
    public Peoples(String name, int id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }
    @Override
    public String toString(){
        return name + " with ID: " + id + " is " + age + " years old.";
    }
}
