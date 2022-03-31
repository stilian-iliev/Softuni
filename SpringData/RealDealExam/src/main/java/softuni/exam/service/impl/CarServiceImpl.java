package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.dtos.car.CarImportDto;
import softuni.exam.models.dtos.car.ExportByPicCountDto;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final Path CARS_JSON_PATH = Path.of("src", "main", "resources", "files", "json", "cars.json");

    private final CarRepository carRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    public CarServiceImpl(CarRepository carRepository, Gson gson, ValidationUtil validator, @Qualifier("date") ModelMapper mapper) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(CARS_JSON_PATH);
    }

    @Override
    public String importCars() throws IOException {
        CarImportDto[] carDtos = gson.fromJson(new FileReader(CARS_JSON_PATH.toString()), CarImportDto[].class);

        List<String> output = new ArrayList<>();
        for (CarImportDto carDto : carDtos) {
            boolean exists = carRepository.findByMakeAndModelAndKilometers(carDto.getMake(), carDto.getModel(), carDto.getKilometers()).isPresent();
            if (validator.isValid(carDto) && !exists) {
                Car car = mapper.map(carDto, Car.class);
                carRepository.save(car);
                output.add(String.format("Successfully imported car - %s - %s", car.getMake(), car.getModel()));
            } else {
                output.add("Invalid car");
            }
        }

        return String.join("\n", output);
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        List<ExportByPicCountDto> allByPicCount = carRepository.findAllByPicCount();

        return allByPicCount.stream().map(ExportByPicCountDto::toString).collect(Collectors.joining("\n\n"));
    }
}
