package bg.softuni.musicdb.seeders;

import bg.softuni.musicdb.models.Artist;
import bg.softuni.musicdb.repositories.ArtistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArtistSeeder implements CommandLineRunner {
    private ArtistRepository artistRepository;

    public ArtistSeeder(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (artistRepository.count() == 0) {
            List<Artist> artists = new ArrayList<>();

            artists.add(new Artist("Madonna", null));
            artists.add(new Artist("Metallica", null));
            artists.add(new Artist("Queen", null));

            artistRepository.saveAll(artists);
        }
    }
}
