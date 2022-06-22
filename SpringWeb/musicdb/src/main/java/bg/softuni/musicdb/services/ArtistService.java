package bg.softuni.musicdb.services;

import bg.softuni.musicdb.models.Artist;
import bg.softuni.musicdb.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void add(Artist artist) {

    }
}
