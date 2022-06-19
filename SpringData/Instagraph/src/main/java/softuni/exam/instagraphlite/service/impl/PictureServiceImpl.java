package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.dtos.picture.PictureImportDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    private final Path PICTURES_JSON_PATH = Path.of("src", "main", "resources", "files" , "pictures.json");

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper mapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, Validator validator, ModelMapper mapper) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(PICTURES_JSON_PATH);
    }

    @Override
    public String importPictures() throws IOException {
        PictureImportDto[] pictureDtos = gson.fromJson(new FileReader(PICTURES_JSON_PATH.toString()), PictureImportDto[].class);
        List<String> output = new ArrayList<>();
        for (PictureImportDto pictureDto : pictureDtos) {
            Set<ConstraintViolation<PictureImportDto>> errors = validator.validate(pictureDto);
            if (errors.isEmpty() && pictureRepository.findByPath(pictureDto.getPath()) == null) {
                Picture picture = mapper.map(pictureDto, Picture.class);
                pictureRepository.save(picture);
                output.add(String.format("Successfully imported Picture, with size %.2f", picture.getSize()));
            } else {
                output.add("Invalid Picture");
            }

        }

        return String.join("\n", output);
    }

    @Override
    public String exportPictures() {
        List<Picture> withSizeGreaterThan30000 = pictureRepository.findAllBySizeGreaterThanOrderBySizeAsc(30000);

        return withSizeGreaterThan30000.stream().map(p -> String.format("%.2f - %s", p.getSize(), p.getPath())).collect(Collectors.joining("\n"));
    }
}
