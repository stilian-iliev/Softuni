package Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Tuple> tuples = new ArrayList<Tuple>();

        String[] input = sc.nextLine().split("\\s+");
        tuples.add(new Tuple<String,String>(input[0]+ " " + input[1], input[2]));

        input = sc.nextLine().split("\\s+");

        tuples.add(new Tuple<String,Integer>(input[0], Integer.parseInt(input[1])));

        input = sc.nextLine().split("\\s+");
        tuples.add(new Tuple<Integer,Double>(Integer.parseInt(input[0]), Double.parseDouble(input[1])));

        tuples.forEach(t-> System.out.println(t.getKey() +" -> "+t.getValue()));

    }
}
