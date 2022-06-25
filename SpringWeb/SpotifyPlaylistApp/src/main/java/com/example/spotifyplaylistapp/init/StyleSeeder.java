package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.models.Style;
import com.example.spotifyplaylistapp.models.enums.StyleEnum;
import com.example.spotifyplaylistapp.repositories.StyleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StyleSeeder implements CommandLineRunner {
    private final StyleRepository styleRepository;

    public StyleSeeder(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Style> styles = new ArrayList<>();
        for (StyleEnum value : StyleEnum.values()) {
            if (!styleRepository.existsByName(value)) {
                styles.add(new Style(value));
            }
        }
        if (!styles.isEmpty()) {
            styleRepository.saveAll(styles);
        }
    }
}
