package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String,Trainer> trainers = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("Tournament")){

            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int hp = Integer.parseInt(tokens[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName,0,new ArrayList<>()));
            trainers.get(trainerName).addPokemon(pokemonName,pokemonElement,hp);

            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!input.equals("End")){
            for (Trainer trainer : trainers.values()) {
                trainer.hasPokemon(input);
            }
            input = sc.nextLine();
        }
        trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getBadges).reversed())
                .forEach(e-> System.out.println(e.toString()));
    }
}
