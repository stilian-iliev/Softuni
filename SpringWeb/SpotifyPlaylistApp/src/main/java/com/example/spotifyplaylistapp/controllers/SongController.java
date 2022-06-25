package com.example.spotifyplaylistapp.controllers;

import com.example.spotifyplaylistapp.models.Song;
import com.example.spotifyplaylistapp.models.dtos.AddSongDto;
import com.example.spotifyplaylistapp.services.AuthService;
import com.example.spotifyplaylistapp.services.SongService;
import com.example.spotifyplaylistapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {
    private SongService songService;
    private UserService userService;
    private AuthService authService;

    public SongController(SongService songService, UserService userService, AuthService authService) {
        this.songService = songService;
        this.userService = userService;
        this.authService = authService;
    }

    @ModelAttribute("addSongDto")
    public AddSongDto addSongDto() {
        return new AddSongDto();
    }

    @GetMapping("/add")
    public String getAdd() {
        if (!authService.isActive()) return "redirect:/";
        return "song-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddSongDto addSongDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (!authService.isActive()) return "redirect:/";

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addSongDto", addSongDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSongDto", bindingResult);
            return "redirect:/add";
        }
        songService.add(addSongDto);
        return "redirect:/";
    }

    @GetMapping("/save/{id}")
    public String saveSong(@PathVariable("id") Long songId) {
        if (!authService.isActive()) return "redirect:/";

        Song song = songService.getById(songId);
        userService.saveSong(song);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clearPlaylist() {
        if (!authService.isActive()) return "redirect:/";

        userService.cleanPlaylist();
        return "redirect:/";
    }
}
