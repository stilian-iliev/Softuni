package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents = new ArrayList<>();
    private List<Child> children = new ArrayList<>();
    private List<Pokemon> pokemons = new ArrayList<>();

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addParent(Parent parent) {
        parents.add(parent);
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        String compan = "";
        if (company != null) compan += company.toString();

        String ca = "";
        if (car != null) ca += car.toString();

        List<String> pokes = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            pokes.add(pokemon.toString());
        }
        List<String> pare = new ArrayList<>();
        for (Parent parent : parents) {
            pare.add(parent.toString());
        }
        List<String> kids = new ArrayList<>();
        for (Child child : children) {
            kids.add(child.toString());
        }

        return String.format("%s%nCompany: %s%nCar: %s%nPokemon: %s%nParents: %s%nChildren: %s%n"
                , name
                , compan
                , ca
                , String.join("", pokes)
                , String.join("", pare)
                , String.join("", kids));
    }
}
