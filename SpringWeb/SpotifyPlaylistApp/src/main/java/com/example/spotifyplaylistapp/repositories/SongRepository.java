package com.example.spotifyplaylistapp.repositories;

import com.example.spotifyplaylistapp.models.Song;
import com.example.spotifyplaylistapp.models.enums.StyleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    boolean existsByPerformer(String performer);

    List<Song> findAllByStyleName(StyleEnum styleEnum);
}
