package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit){
        if (data.size()<capacity) data.add(rabbit);
    }

    public boolean removeRabbit(String name){
        Rabbit rabbit = data.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null);
        return data.remove(rabbit);
    }

    public void removeSpecies(String species){
        data = data.stream().filter(e-> !e.getSpecies().equals(species)).collect(Collectors.toList());
    }

    public Rabbit sellRabbit(String name){
        Rabbit rabbit = data.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null);
        if (rabbit!= null)rabbit.setAvailable(false);
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> rabbits = new ArrayList<>();
        data.stream().filter(e-> e.getSpecies().equals(species)).forEach(e-> {
            e.setAvailable(false);
            rabbits.add(e);
        });

        return rabbits;
    }

    public int count(){
        return data.size();
    }

    public  String report(){
        return String.format("Rabbits available at %s:%n%s", name, data.stream().filter(Rabbit::isAvailable).map(String::valueOf).collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
