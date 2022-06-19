package softuni.gamestore.services;

import softuni.gamestore.entities.game.GameDto;

public interface GameService {
    void addGame(GameDto gameInfo);

    void editGame(String[] tokens);

    void deleteGame(int id);

    void printGamesSummary();

    void printGameDetails(String title);

    void printOwnedGames();
}
