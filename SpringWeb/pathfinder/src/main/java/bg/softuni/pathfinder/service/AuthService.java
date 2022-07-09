package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dtos.UserRegisterDto;
import bg.softuni.pathfinder.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, ModelMapper mapper,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;

        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegisterDto userRegisterDto) {
        User user = mapper.map(userRegisterDto, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        userRepository.save(user);
    }


    public boolean exists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
