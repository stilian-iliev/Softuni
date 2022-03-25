package softuni.gamestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.gamestore.entities.game.GameDto;
import softuni.gamestore.entities.user.UserDto;
import softuni.gamestore.exceptions.AuthorizationException;
import softuni.gamestore.exceptions.ValidationException;
import softuni.gamestore.services.GameService;
import softuni.gamestore.services.UserService;
import softuni.gamestore.services.impl.UserServiceImpl;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final GameService gameService;
    private final UserService userService;

    @Autowired
    public ConsoleRunner(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equals("stop")) {
            try {
                executeCommand(input);
            } catch (AuthorizationException | ValidationException e) {
                System.out.println(e.getMessage());
            }
            input = sc.nextLine();
        }
    }

    private void executeCommand(String input) {
        String[] tokens = input.split("\\|");
        String action = tokens[0];

        switch (action) {
            case "RegisterUser":
                UserDto userDto = new UserDto(tokens);
                userService.registerUser(userDto);
                break;
            case "LoginUser":
                String email = tokens[1];
                String pass = tokens[2];
                userService.loginUser(email, pass);
                break;
            case "Logout":
                userService.logout();
                break;
            case "AddGame":
                if (UserServiceImpl.getCurrentUser().isAdmin()) {
                    GameDto gameDto = new GameDto(tokens);
                    gameService.addGame(gameDto);
                } else {
                    throw new AuthorizationException("You must be admin to add a game.");
                }
                break;
            case "EditGame":
                if (UserServiceImpl.getCurrentUser().isAdmin()) {
                    gameService.editGame(tokens);
                } else {
                    throw new AuthorizationException("You must be admin to edit a game.");
                }
                break;
            case "DeleteGame":
                if (UserServiceImpl.getCurrentUser().isAdmin()) {
                    gameService.deleteGame(Integer.parseInt(tokens[1]));
                } else {
                    throw new AuthorizationException("You must be admin to edit a game.");
                }
                break;
            case "AllGames":
                gameService.printGamesSummary();
                break;
            case "DetailGame":
                String title = tokens[1];
                gameService.printGameDetails(title);
                break;
            case "OwnedGames":
                if (UserServiceImpl.getCurrentUser() == null) {
                    throw new AuthorizationException("You have to log in to see your games.");
                }
                gameService.printOwnedGames();
                break;
        }
    }
}
