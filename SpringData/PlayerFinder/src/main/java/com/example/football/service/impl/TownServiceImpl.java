package com.example.football.service.impl;

import com.example.football.models.dto.town.TownImportDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
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
public class TownServiceImpl implements TownService {
    private final Path TOWNS_JSON_PATH = Path.of("src", "main", "resources", "files", "json", "towns.json");

    private final TownRepository townRepository;

    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
        gson = new Gson();
        mapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(TOWNS_JSON_PATH);
    }

    @Override
    public String importTowns() throws FileNotFoundException {
        TownImportDto[] townImportDtos = gson.fromJson(new FileReader(TOWNS_JSON_PATH.toString()), TownImportDto[].class);

        List<String> output = new ArrayList<>();
        for (TownImportDto townDto : townImportDtos) {
            if (townRepository.findByName(townDto.getName()) == null && townDto.isValid()) {
                Town town = mapper.map(townDto, Town.class);
                townRepository.save(town);
                output.add(String.format("Successfully imported Town %s %d", town.getName(), town.getPopulation()));
            } else {
                output.add("Invalid Town");
            }
        }
        return String.join("\n", output);
    }
}
