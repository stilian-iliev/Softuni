package com.example.spotifyplaylistapp.repositories;

import com.example.spotifyplaylistapp.models.Style;
import com.example.spotifyplaylistapp.models.enums.StyleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
    boolean existsByName(StyleEnum value);

    Style findByName(StyleEnum style);
}
