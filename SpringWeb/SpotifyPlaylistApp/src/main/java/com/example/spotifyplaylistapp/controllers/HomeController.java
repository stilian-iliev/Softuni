package com.example.spotifyplaylistapp.controllers;

import com.example.spotifyplaylistapp.models.enums.StyleEnum;
import com.example.spotifyplaylistapp.services.AuthService;
import com.example.spotifyplaylistapp.services.SongService;
import com.example.spotifyplaylistapp.services.UserService;
import com.example.spotifyplaylistapp.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private SongService songService;
    private UserService userService;
    private AuthService authService;

    public HomeController(CurrentUser currentUser, SongService songService, UserService userService, AuthService authService) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        if (!authService.isActive()) return "index";

        if (!model.containsAttribute("userPlaylist")) {
            model.addAttribute("userPlaylist", userService.getPlaylist());
        }
        if (!model.containsAttribute("playlistDuration")) {
            model.addAttribute("playlistDuration", userService.getPlaylistDuration());
        }
        if (!model.containsAttribute("popSongs")) {
            model.addAttribute("popSongs", songService.getStyleSongs(StyleEnum.POP));
        }
        if (!model.containsAttribute("rockSongs")) {
            model.addAttribute("rockSongs", songService.getStyleSongs(StyleEnum.ROCK));
        }
        if (!model.containsAttribute("jazzSongs")) {
            model.addAttribute("jazzSongs", songService.getStyleSongs(StyleEnum.JAZZ));
        }
        return "home" ;
    }

}
