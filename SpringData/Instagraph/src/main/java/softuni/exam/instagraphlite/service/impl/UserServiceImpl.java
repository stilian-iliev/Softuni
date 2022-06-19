package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dtos.user.UserImportDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;

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
public class UserServiceImpl implements UserService {
    private final Path USERS_JSON_PATH = Path.of("src", "main", "resources", "files" , "users.json");

    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, Gson gson, Validator validator, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(USERS_JSON_PATH);
    }

    @Override
    public String importUsers() throws IOException {
        UserImportDto[] usersDtos = gson.fromJson(new FileReader(USERS_JSON_PATH.toString()), UserImportDto[].class);
        List<String> output = new ArrayList<>();
        for (UserImportDto userDto : usersDtos) {
            Set<ConstraintViolation<UserImportDto>> errors = validator.validate(userDto);
            Picture picture = pictureRepository.findByPath(userDto.getProfilePicture());
            if (errors.isEmpty() && picture != null && userRepository.findByUsername(userDto.getUsername()) == null) {
                User user = mapper.map(userDto, User.class);
                user.setProfilePicture(picture);
                userRepository.save(user);
                output.add(String.format("Successfully imported User: %s", user.getUsername()));
            } else {
                output.add("Invalid User");
            }
        }
        return String.join("\n", output);
    }

    @Override
    public String exportUsersWithTheirPosts() {
        List<User> allOrderedByPostCount = userRepository.findAllOrderedByPostCount();
        allOrderedByPostCount.forEach(u -> {
            u.getPosts().sort((r,l)-> (int) (r.getPicture().getSize() - l.getPicture().getSize()));
        });
        return allOrderedByPostCount.stream().map(User::toString).collect(Collectors.joining("\n"));
    }
}
