package bg.softuni.musicdb.services;


import bg.softuni.musicdb.models.User;
import bg.softuni.musicdb.models.dtos.UserRegisterDto;
import bg.softuni.musicdb.repositories.UserRepository;
import bg.softuni.musicdb.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final CurrentUser currentUser;

    public AuthService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.mapper = new ModelMapper();
    }

    public void register(UserRegisterDto userRegisterDto) {
        User user = mapper.map(userRegisterDto, User.class);
        userRepository.save(user);
    }

//    public boolean login(LoginDto loginDto) {
//        Optional<User> user = userRepository.findByUsername(loginDto.getUsername());
//        if (user.isEmpty()) return false;
//        if (!user.get().getPassword().equals(loginDto.getPassword())) return false;
//        currentUser.login(user.get());
//        return true;
//    }
//
//    public void logout() {
//        currentUser.logout();
//    }
}
