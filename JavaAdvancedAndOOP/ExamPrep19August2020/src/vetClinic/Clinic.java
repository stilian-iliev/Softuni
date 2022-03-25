package vetClinic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) data.add(pet);
    }

    public boolean remove(String name){
        Pet pet = data.stream().filter(p-> p.getName().equals(name)).findFirst().orElse(null);
        if (pet == null) return false;
        else {
            data.remove(pet);
            return true;
        }
    }

    public Pet getPet(String name, String owner){
        return data.stream()
                .filter(e-> e.getName().equals(name) && e.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public Pet getOldestPet(){
        return data.stream().max((f,s)-> Integer.compare(f.getAge(), s.getAge()))
                .orElse(null);
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        return String.format("The clinic has the following patients:%n%s",data.stream().map(e-> String.format("%s %s",e.getName(),e.getOwner())).collect(Collectors.joining(System.lineSeparator())));
    }

}
