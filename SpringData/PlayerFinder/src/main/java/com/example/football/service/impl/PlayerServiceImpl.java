package com.example.football.service.impl;

import com.example.football.models.dto.player.PlayerDto;
import com.example.football.models.dto.player.PlayerImportDto;
import com.example.football.models.dto.player.PlayerListImportDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.models.entity.enums.PlayerPosition;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final Path PLAYERS_XML_PATH = Path.of("src", "main", "resources", "files", "xml", "players.xml");

    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;
    private final StatRepository statRepository;
    private final ModelMapper mapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository, TeamRepository teamRepository, StatRepository statRepository) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        mapper = new ModelMapper();
        mapper.addConverter(new Converter<String, PlayerPosition>() {
            @Override
            public PlayerPosition convert(MappingContext<String, PlayerPosition> mappingContext) {
                return PlayerPosition.valueOf(mappingContext.getSource());
            }
        });
        mapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(PLAYERS_XML_PATH);
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(PlayerListImportDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        PlayerListImportDto playersListDto = (PlayerListImportDto) unmarshaller.unmarshal(new FileReader(PLAYERS_XML_PATH.toString()));
        List<String> output = new ArrayList<>();
        for (PlayerImportDto playerDto : playersListDto.getPlayers()) {
            if (playerRepository.findByEmail(playerDto.getEmail()) == null && playerDto.isValid()) {
                Player player = mapper.map(playerDto, Player.class);
                Town town = townRepository.findByName(playerDto.getTownName().getName());
                Team team = teamRepository.findByName(playerDto.getTeamName().getName());
                Stat stat = statRepository.findById(playerDto.getStatId().getId()).get();
                player.setTown(town);
                player.setTeam(team);
                player.setStat(stat);
                playerRepository.save(player);
                output.add(String.format("Successfully imported Player %s %s - %s",player.getFirstName(), player.getLastName(), player.getPosition().name()));
            } else {
                output.add("Invalid Player");
            }
        }
        return String.join("\n", output);
    }

    @Override
    public String exportBestPlayers() {
        List<PlayerDto> bestPlayers = playerRepository.findBestPlayers();

        return bestPlayers.stream().map(PlayerDto::toString).collect(Collectors.joining("\n"));
    }
}
