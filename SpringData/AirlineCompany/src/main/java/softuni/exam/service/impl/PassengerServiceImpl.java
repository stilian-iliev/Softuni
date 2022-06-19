package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.Passenger;
import softuni.exam.models.Town;
import softuni.exam.models.dto.passenger.PassengerExportDto;
import softuni.exam.models.dto.passenger.PassengerImportDto;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final Path PASSENGERS_JSON_PATH = Path.of("src", "main", "resources", "files", "json", "passengers.json");

    private final ValidationUtil validator;
    private final PassengerRepository passengerRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    public PassengerServiceImpl(ValidationUtil validator, PassengerRepository passengerRepository, TownRepository townRepository, Gson gson, ModelMapper mapper) {
        this.validator = validator;
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(PASSENGERS_JSON_PATH);
    }

    @Override
    public String importPassengers() throws IOException {
        PassengerImportDto[] passengerImportDtos = gson.fromJson(new FileReader(PASSENGERS_JSON_PATH.toString()), PassengerImportDto[].class);
        List<String> output = new ArrayList<>();
        for (PassengerImportDto passengerDto : passengerImportDtos) {
            Optional<Town> town = townRepository.findByName(passengerDto.getTown());
            boolean exists = passengerRepository.findByEmail(passengerDto.getEmail()).isPresent();
            if (!exists && town.isPresent() && validator.isValid(passengerDto)) {
                Passenger passenger = mapper.map(passengerDto, Passenger.class);
                passenger.setTown(town.get());
                passengerRepository.save(passenger);
                output.add(String.format("Successfully imported Passenger %s - %s", passenger.getLastName(), passenger.getEmail()));
            } else {
                output.add("Invalid Passenger");
            }
        }

        return String.join("\n", output);
    }

    @Override
    @Transactional
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        List<Passenger> allPassengersByTicketCount = passengerRepository.findAllPassengersByTicketCount();
        return allPassengersByTicketCount.stream().map(Passenger::toString).collect(Collectors.joining("\n\n"));
    }
}
