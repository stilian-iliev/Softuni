package StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        String input = sc.readLine();
        while (!input.equals("END")){
            if (input.equals("Pop")){
                stack.pop();
            } else {
                push(input,stack);
            }
            input = sc.readLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
    private static void push(String input, Stack<Integer> stack){
        input = input.substring(5).replace(",","");
        List<Integer> numbers = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        numbers.forEach(stack::push);
    }
}
