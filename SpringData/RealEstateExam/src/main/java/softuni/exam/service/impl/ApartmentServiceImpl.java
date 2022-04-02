package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.apartment.ApartmentImportDto;
import softuni.exam.models.dto.apartment.ApartmentListDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final Path APARTMENTS_JSON_PATH = Path.of("src", "main", "resources", "files", "xml", "apartments.xml");

    private final TownRepository townRepository;
    private final ApartmentRepository apartmentRepository;
    private final XmlParser xmlParser;
    private final ModelMapper mapper;
    private final ValidationUtil validation;

    public ApartmentServiceImpl(TownRepository townRepository, ApartmentRepository apartmentRepository, XmlParser xmlParser, ModelMapper mapper, ValidationUtil validation) {
        this.townRepository = townRepository;
        this.apartmentRepository = apartmentRepository;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
        this.validation = validation;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(APARTMENTS_JSON_PATH);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        ApartmentListDto apartmentListDto = xmlParser.fromFile(APARTMENTS_JSON_PATH.toString(), ApartmentListDto.class);

        List<String > output = new ArrayList<>();
        for (ApartmentImportDto apartmentDto : apartmentListDto.getApartments()) {
            boolean unique = apartmentRepository.findByTownTownNameAndArea(apartmentDto.getTown(), apartmentDto.getArea()).isEmpty();
            if (validation.isValid(apartmentDto) && unique) {
                Apartment apartment = mapper.map(apartmentDto, Apartment.class);
                Town town = townRepository.findByTownName(apartmentDto.getTown()).get();
                apartment.setTown(town);
                apartmentRepository.save(apartment);
                output.add(String.format("Successfully imported apartment %s - %.2f", apartment.getApartmentType().name(), apartmentDto.getArea()));
            } else {
                output.add("Invalid apartment");
            }
        }

        return String.join("\n", output);
    }
}
