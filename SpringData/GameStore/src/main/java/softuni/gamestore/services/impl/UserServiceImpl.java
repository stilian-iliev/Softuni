package softuni.gamestore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.gamestore.entities.user.User;
import softuni.gamestore.entities.user.UserDto;
import softuni.gamestore.exceptions.AuthorizationException;
import softuni.gamestore.exceptions.ValidationException;
import softuni.gamestore.repositories.UserRepository;
import softuni.gamestore.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private static User currentUser;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void registerUser(UserDto userDto) {
        User user = new User(userDto.getEmail(), userDto.getPassword(), userDto.getFullName());

        if (userRepository.count() == 0) {
            user.setAdmin(true);
        }
        userRepository.save(user);
        System.out.println(user.getFullName() + " was registered");
    }

    @Override
    public void loginUser(String email, String pass) {
        if (currentUser != null) throw new AuthorizationException("You are already logged in.");
        User user = userRepository.findByEmailAndPassword(email, pass);
        if (user == null) {
            throw new ValidationException("Incorrect username / password");
        }
        currentUser = user;
        System.out.println("Successfully logged in " + user.getFullName());
    }

    @Override
    public void logout() {
        if (currentUser != null) {
            currentUser = null;
        } else {
            throw new AuthorizationException("You are not logged in.");
        }
    }
}
