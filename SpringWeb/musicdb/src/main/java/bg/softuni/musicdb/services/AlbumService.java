package bg.softuni.musicdb.services;

import bg.softuni.musicdb.models.Album;
import bg.softuni.musicdb.models.Artist;
import bg.softuni.musicdb.models.dtos.AddAlbumDto;
import bg.softuni.musicdb.repositories.AlbumRepository;
import bg.softuni.musicdb.repositories.UserRepository;
import bg.softuni.musicdb.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final ArtistService artistService;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper mapper;

    public AlbumService(AlbumRepository albumRepository, ArtistService artistService, UserRepository userRepository, CurrentUser currentUser, ModelMapper mapper) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.mapper = mapper;
    }

    public void add(AddAlbumDto addAlbumDto) {
        if (!currentUser.isActive()) return;
        Optional<Artist> artist = artistService.findByName(addAlbumDto.getArtist());
        if (artist.isEmpty()) return;
        Album album = mapper.map(addAlbumDto, Album.class);
        album.setArtist(artist.get());
        album.setAddedFrom(userRepository.findById(currentUser.getId()).get());
        albumRepository.save(album);

    }
}
