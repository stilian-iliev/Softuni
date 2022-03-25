package exam.service.impl;

import exam.model.town.Town;
import exam.model.town.TownImportDto;
import exam.model.town.TownListImportDto;
import exam.repository.TownRepository;
import exam.service.TownService;
import org.modelmapper.ModelMapper;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {
    private final Path TOWNS_XML_PATH = Path.of("src", "main", "resources", "files", "xml", "towns.xml");

    private final TownRepository townRepository;

    private final ModelMapper mapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
        mapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(TOWNS_XML_PATH);
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(TownListImportDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        TownListImportDto importDto = (TownListImportDto) unmarshaller.unmarshal(new FileReader(TOWNS_XML_PATH.toString()));

        List<Town> towns = new ArrayList<>();
        List<String> output = new ArrayList<>();
        for (TownImportDto town : importDto.getTowns()) {
            if (town.validate()) {
                Town map = mapper.map(town, Town.class);
                if (townRepository.findByName(town.getName()) != null) {
                    output.add("Duplicate Town");
                } else {
                    towns.add(map);
                    output.add(String.format("Successfully imported Town %s", map.getName()));
                }
            } else {
                output.add("Invalid Town");
            }

        }
        townRepository.saveAll(towns);
        return String.join("\n", output);
    }
}
