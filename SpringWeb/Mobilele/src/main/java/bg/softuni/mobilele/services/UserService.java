package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.User;
import bg.softuni.mobilele.models.dtos.UserRegisterDto;
import bg.softuni.mobilele.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean register(UserRegisterDto userRegisterDto) {
        if (userRepository.findByUsername(userRegisterDto.getUsername()).isPresent()) return false;
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getRePass())) return false;

        User newUser = new User(userRegisterDto.getFirstName(),
                userRegisterDto.getLastName(),
                userRegisterDto.getUsername(),
                passwordEncoder.encode(userRegisterDto.getPassword()));

        userRepository.save(newUser);

        return true;

    }

}
