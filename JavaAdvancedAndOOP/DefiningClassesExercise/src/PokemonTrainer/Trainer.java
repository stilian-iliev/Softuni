package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name, int badges, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = badges;
        this.pokemons = pokemons;
    }

    public void addPokemon(String name, String element, int health) {
        pokemons.add(new Pokemon(name, element, health));
    }

    public boolean hasPokemon(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                badges++;
                return true;
            }
        }
        List<Pokemon> pokemonsToRemove = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            pokemon.loseHP();
            if (pokemon.getHealth() <= 0) pokemonsToRemove.add(pokemon);
        }
        for (Pokemon pokemon : pokemonsToRemove) {
            pokemons.remove(pokemon);
        }
        return false;
    }

    public int getBadges() {
        return badges;
    }
    public String toString(){
        return String.format("%s %d %d",name,badges,pokemons.size());
    }
}
