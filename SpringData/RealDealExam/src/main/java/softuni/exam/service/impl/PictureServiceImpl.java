package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.Picture;
import softuni.exam.models.dtos.picture.PictureImportDto;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {
    private final Path PICTURES_JSON_PATH = Path.of("src", "main", "resources", "files", "json", "pictures.json");

    private final PictureRepository pictureRepository;
    private final CarRepository carRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    public PictureServiceImpl(PictureRepository pictureRepository, CarRepository carRepository, Gson gson, ValidationUtil validator, @Qualifier("dateTime") ModelMapper mapper) {
        this.pictureRepository = pictureRepository;
        this.carRepository = carRepository;
        this.gson = gson;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(PICTURES_JSON_PATH);
    }

    @Override
    public String importPictures() throws IOException {
        PictureImportDto[] pictureDtos = gson.fromJson(new FileReader(PICTURES_JSON_PATH.toString()), PictureImportDto[].class);

        List<String> output = new ArrayList<>();
        for (PictureImportDto pictureDto : pictureDtos) {
            Optional<Car> car = carRepository.findById((long) pictureDto.getCar());
            if (validator.isValid(pictureDto) && car.isPresent()){
                Picture picture = mapper.map(pictureDto, Picture.class);
                picture.setCar(car.get());
                pictureRepository.save(picture);
                output.add(String.format("Successfully import picture - %s", picture.getName()));
            } else {
                output.add("Invalid picture");
            }
        }

        return String.join("\n", output);
    }
}
