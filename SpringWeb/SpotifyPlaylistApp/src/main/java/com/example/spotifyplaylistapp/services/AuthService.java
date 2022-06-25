package com.example.spotifyplaylistapp.services;

import com.example.spotifyplaylistapp.models.User;
import com.example.spotifyplaylistapp.models.dtos.LoginDto;
import com.example.spotifyplaylistapp.models.dtos.RegisterDto;
import com.example.spotifyplaylistapp.repositories.UserRepository;
import com.example.spotifyplaylistapp.session.CurrentUser;
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

    public void register(RegisterDto registerDto) {
        User user = mapper.map(registerDto, User.class);
        userRepository.save(user);
    }

    public boolean login(LoginDto loginDto) {
        Optional<User> user = userRepository.findByUsername(loginDto.getUsername());
        if (user.isEmpty()) return false;
        if (!user.get().getPassword().equals(loginDto.getPassword())) return false;
        currentUser.login(user.get());
        return true;
    }

    public void logout() {
        currentUser.logout();
    }

    public User getCurrentUser() {
        return userRepository.findById(currentUser.getId()).get();
    }

    public boolean isActive() {
        return currentUser.isActive();
    }
}
