package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Town;
import softuni.exam.models.dto.town.TownImportDto;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

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

    private final ValidationUtil validator;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public TownServiceImpl(ValidationUtil validator, TownRepository townRepository, Gson gson, ModelMapper mapper) {
        this.validator = validator;
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
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
            if (validator.isValid(townDto) && townRepository.findByName(townDto.getName()).isEmpty()) {
                Town town = mapper.map(townDto, Town.class);
                townRepository.save(town);
                output.add(String.format("Successfully imported Town %s - %d", town.getName(), town.getPopulation()));
            } else {
                output.add("Invalid Town");
            }
        }

        return String.join("\n", output);
    }
}
