package bg.softuni.battleships.services;

import bg.softuni.battleships.models.User;
import bg.softuni.battleships.models.dtos.UserRegisterDto;
import bg.softuni.battleships.reposiotories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }

    public void register(UserRegisterDto userRegisterDto) {
        User user = mapper.map(userRegisterDto, User.class);
        userRepository.save(user);
    }
}
