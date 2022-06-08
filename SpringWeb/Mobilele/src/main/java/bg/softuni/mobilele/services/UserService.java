package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.User;
import bg.softuni.mobilele.models.dtos.UserLoginDto;
import bg.softuni.mobilele.models.dtos.UserRegisterDto;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private CurrentUser currentUser;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<User> userOpt = userRepository.findByUsername(userLoginDto.getUsername());
        if (userOpt.isEmpty()) return false;

        var rawPassword = userLoginDto.getPassword();
        var encodedPassword = userOpt.get().getPassword();

        if (!passwordEncoder.matches(rawPassword, encodedPassword)) return false;

        currentUser.login(userOpt.get());
        return true;
    }

    public boolean register(UserRegisterDto userRegisterDto) {
        if (userRepository.findByUsername(userRegisterDto.getUsername()).isPresent()) return false;
//        if (!userRegisterDto.getPassword().equals(userRegisterDto.getRePass())) return false;

        User newUser = new User(userRegisterDto.getFirstName(),
                userRegisterDto.getLastName(),
                userRegisterDto.getUsername(),
                passwordEncoder.encode(userRegisterDto.getPassword()));

        userRepository.save(newUser);

        return true;

    }

    public void logout() {
        this.currentUser.logout();
    }
}
