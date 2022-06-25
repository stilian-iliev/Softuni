package com.example.spotifyplaylistapp.services;

import com.example.spotifyplaylistapp.models.Song;
import com.example.spotifyplaylistapp.models.User;
import com.example.spotifyplaylistapp.repositories.UserRepository;
import com.example.spotifyplaylistapp.session.CurrentUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, AuthService authService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.authService = authService;
        this.currentUser = currentUser;
    }

    public void addSongToCurrentUser() {
        authService.getCurrentUser();
    }

    public void saveSong(Song song) {
        User user = authService.getCurrentUser();
        user.addSongToPlaylist(song);
        userRepository.save(user);
    }

    @Transactional
    public Set<Song> getPlaylist() {
        return userRepository.findById(currentUser.getId()).get().getPlaylist();
    }

    public void cleanPlaylist() {
        User user = userRepository.findById(currentUser.getId()).get();
        user.removeAllSongsFromPlaylist();
        userRepository.save(user);
    }

    public String getPlaylistDuration() {
        int sum = getPlaylist().stream()
                .mapToInt(Song::getDuration)
                .sum();

        long HH = sum / 3600;
        long MM = (sum % 3600) / 60;
        long SS = sum % 60;
        return String.format("%02d:%02d:%02d", HH, MM, SS);
    }
}
