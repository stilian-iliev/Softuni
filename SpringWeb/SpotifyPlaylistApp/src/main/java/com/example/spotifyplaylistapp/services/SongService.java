package com.example.spotifyplaylistapp.services;

import com.example.spotifyplaylistapp.models.Song;
import com.example.spotifyplaylistapp.models.dtos.AddSongDto;
import com.example.spotifyplaylistapp.models.enums.StyleEnum;
import com.example.spotifyplaylistapp.repositories.SongRepository;
import com.example.spotifyplaylistapp.repositories.StyleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;
    private final StyleRepository styleRepository;
    private final ModelMapper mapper;

    public SongService(SongRepository songRepository, StyleRepository styleRepository, ModelMapper mapper) {
        this.songRepository = songRepository;
        this.styleRepository = styleRepository;
        this.mapper = mapper;
    }


    public void add(AddSongDto addSongDto) {
        Song song = mapper.map(addSongDto, Song.class);
        song.setStyle(styleRepository.findByName(addSongDto.getStyle()));
        songRepository.save(song);
    }

    public List<Song> getStyleSongs(StyleEnum styleEnum) {
        return songRepository.findAllByStyleName(styleEnum);
    }

    public Song getById(Long songId) {
        return songRepository.getById(songId);
    }
}
