package softuni.gamestore.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.gamestore.entities.game.Game;
import softuni.gamestore.entities.game.GameDto;
import softuni.gamestore.exceptions.InvalidArgumentException;
import softuni.gamestore.repositories.GameRepository;
import softuni.gamestore.repositories.UserRepository;
import softuni.gamestore.services.GameService;

import java.math.BigDecimal;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addGame(GameDto gameInfo) {
        ModelMapper mapper = new ModelMapper();
        Game game = mapper.map(gameInfo, Game.class);
        System.out.println(game);
        gameRepository.save(game);
        System.out.println("Added " + game.getTitle());
    }

    @Override
    public void editGame(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        Game game = gameRepository.findById(id);
        if (game == null) {
            throw new InvalidArgumentException("Game with such id doesn't exist");
        }
        System.out.println(game);

        for (int i = 2; i < tokens.length; i++) {
            String property = tokens[i].split("=")[0];
            String value = tokens[i].split("=")[1];

            switch (property) {
                case "title":
                    game.setTitle(value);
                    break;
                case "price":
                    game.setPrice(new BigDecimal(value));
                    break;
                case "size":
                    game.setSize(Double.parseDouble(value));
                    break;
                case "trailer":
                    game.setTrailer(value);
                    break;
                case "image":
                    game.setImage(value);
                    break;
            }
        }
        gameRepository.save(game);

        System.out.println("Edited "+ game.getTitle());
    }

    @Transactional
    @Modifying
    @Override
    public void deleteGame(int id) {
        Game game = gameRepository.getById(id);
        gameRepository.deleteById(id);
        System.out.println("Deleted " + game.getTitle());
    }

    @Override
    public void printGamesSummary() {
        gameRepository.findAll().stream().map(g -> String.format("%s %.2f", g.getTitle(), g.getPrice())).forEach(System.out::println);
    }

    @Override
    public void printGameDetails(String title) {
        Game game = gameRepository.findFirstByTitle(title);
        System.out.println(game);
    }

    @Transactional
    @Override
    public void printOwnedGames() {
        userRepository.findById(UserServiceImpl.getCurrentUser().getId()).get().getGames().stream().map(Game::getTitle).forEach(System.out::println);
    }
}
