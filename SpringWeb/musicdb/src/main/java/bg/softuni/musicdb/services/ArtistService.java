package bg.softuni.musicdb.services;

import bg.softuni.musicdb.models.Artist;
import bg.softuni.musicdb.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void add(Artist artist) {

    }

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> findByName(String artist) {
        return artistRepository.findByName(artist);
    }
}
