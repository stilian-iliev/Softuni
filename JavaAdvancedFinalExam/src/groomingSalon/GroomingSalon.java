package groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (data.size()< capacity) data.add(pet);
    }

    public boolean remove(String name){
        Pet pet = data.stream()
                .filter(e-> e.getName().equals(name))
                .findFirst().orElse(null);
        return data.remove(pet);
    }

    public Pet getPet(String name, String owner){
        return data.stream()
                .filter(e-> e.getName().equals(name) && e.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        return String.format(" The grooming salon has the following clients:%n%s"
                ,data.stream()
                        .map(e->String.format("%s %s",e.getName(),e.getOwner()))
                        .collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
