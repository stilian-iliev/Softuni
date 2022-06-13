package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dtos.UserLoginDto;
import bg.softuni.pathfinder.models.dtos.UserRegisterDto;
import bg.softuni.pathfinder.repositories.UserRepository;
import bg.softuni.pathfinder.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final CurrentUser currentUser;

    public AuthService(UserRepository userRepository, ModelMapper mapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.currentUser = currentUser;
    }

    public void register(UserRegisterDto userRegisterDto) {
        User user = mapper.map(userRegisterDto, User.class);
        userRepository.save(user);
    }

    public boolean login(UserLoginDto userLoginDto) {
        //check if exists

        Optional<User> user = userRepository.findByUsername(userLoginDto.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(userLoginDto.getPassword())) {
            currentUser.login(user.get());
            return true;
        }
        return false;
    }

    public boolean exists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
