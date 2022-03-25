package com.example.football.service.impl;

import com.example.football.models.dto.team.TeamImportDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private final Path TEAMS_JSON_PATH = Path.of("src", "main", "resources", "files", "json", "teams.json");

    private final TeamRepository teamRepository;
    private final TownRepository townRepository;

    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        gson = new Gson();
        mapper = new ModelMapper();

//        mapper.addConverter(new Converter<String, Town>() {
//            @Override
//            public Town convert(MappingContext<String, Town> mappingContext) {
//                return townRepository.findByName(mappingContext.getSource());
//            }
//        });
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 1;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(TEAMS_JSON_PATH);
    }

    @Override
    public String importTeams() throws FileNotFoundException {
        TeamImportDto[] teamImportDtos = gson.fromJson(new FileReader(TEAMS_JSON_PATH.toString()), TeamImportDto[].class);
        List<String> output = new ArrayList<>();
        for (TeamImportDto teamDto : teamImportDtos) {
            if (teamRepository.findByName(teamDto.getName()) == null && teamDto.isValid()) {
                Team team = mapper.map(teamDto, Team.class);
                Town town = townRepository.findByName(teamDto.getTownName());
                team.setTown(town);
                teamRepository.save(team);
                output.add(String.format("Successfully imported Team %s - %d", team.getName(), team.getFanBase()));
            } else {
                output.add("Invalid Team");
            }
        }
        return String.join("\n", output);
    }
}
