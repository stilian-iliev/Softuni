package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dtos.UserRegisterDto;
import bg.softuni.pathfinder.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public AuthService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public void register(UserRegisterDto userRegisterDto) {
        User user = mapper.map(userRegisterDto, User.class);
        userRepository.save(user);
    }

    public boolean exists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
