package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Plane;
import softuni.exam.models.dto.plane.PlaneImportDto;
import softuni.exam.models.dto.plane.PlaneListImportDto;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

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
public class PlaneServiceImpl implements PlaneService {
    private final Path PLANE_JSON_PATH = Path.of("src", "main", "resources", "files", "xml", "planes.xml");

    private final ValidationUtil validator;
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;
    private final ModelMapper mapper;

    public PlaneServiceImpl(ValidationUtil validator, PlaneRepository planeRepository, XmlParser xmlParser, ModelMapper mapper) {
        this.validator = validator;
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(PLANE_JSON_PATH);
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(PlaneListImportDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        PlaneListImportDto planeListImportDto = (PlaneListImportDto)unmarshaller.unmarshal(new FileReader(PLANE_JSON_PATH.toString()));

        List<String> output = new ArrayList<>();

        for (PlaneImportDto planeDto : planeListImportDto.getPlanes()) {
            if (validator.isValid(planeDto) && planeRepository.findByRegisterNumber(planeDto.getRegisterNumber()).isEmpty()) {
                Plane plane = mapper.map(planeDto, Plane.class);
                planeRepository.save(plane);
                output.add(String.format("Successfully imported Plane %s", plane.getRegisterNumber()));
            } else {
                output.add("Invalid Plane");
            }
        }
        return String.join("\n", output);
    }
}
