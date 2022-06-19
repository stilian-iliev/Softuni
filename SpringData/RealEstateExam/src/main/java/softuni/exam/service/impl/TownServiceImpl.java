package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.town.TownImportDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

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
    private final ValidationUtil validation;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper mapper, ValidationUtil validation) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validation = validation;
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
    public String importTowns() throws IOException {
        TownImportDto[] townImportDtos = gson.fromJson(new FileReader(TOWNS_JSON_PATH.toString()), TownImportDto[].class);

        List<String> output = new ArrayList<>();
        for (TownImportDto townDto : townImportDtos) {
            if (validation.isValid(townDto) && townRepository.findByTownName(townDto.getTownName()).isEmpty()){
                Town town = mapper.map(townDto, Town.class);
                townRepository.save(town);
                output.add(String.format("Successfully imported town %s - %d", town.getTownName(), town.getPopulation()));
            } else {
                output.add("Invalid town");
            }
        }
        return String.join("\n", output);
    }
}
