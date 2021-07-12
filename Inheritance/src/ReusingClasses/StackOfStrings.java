package ReusingClasses;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings(){
        data = new ArrayList<>();
    }

    public void push(String element){
        data.add(element);
    }

    public String pop(){
        String temp = data.get(data.size()-1);
        data.remove(temp);
        return temp;
    }

    public String peek(){
        return data.get(data.size()-1);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
