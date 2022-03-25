package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dtos.post.PostImportDto;
import softuni.exam.instagraphlite.models.dtos.post.PostsListImportDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {
    private final Path POSTS_XML_PATH = Path.of("src", "main", "resources", "files" , "posts.xml");

    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final PostRepository postRepository;
    private final Validator validator;
    private final ModelMapper mapper;

    @Autowired
    public PostServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, PostRepository postRepository, Validator validator, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.postRepository = postRepository;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(POSTS_XML_PATH);
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(PostsListImportDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        PostsListImportDto postsList = (PostsListImportDto) unmarshaller.unmarshal(new FileReader(POSTS_XML_PATH.toString()));
        List<String> output = new ArrayList<>();
        for (PostImportDto postDto : postsList.getPosts()) {
            Set<ConstraintViolation<PostImportDto>> errors = validator.validate(postDto);
            User user = userRepository.findByUsername(postDto.getUser().getUsername());
            Picture picture = pictureRepository.findByPath(postDto.getPicture().getPath());
            if (errors.isEmpty() && user != null && picture != null) {
                Post post = mapper.map(postDto, Post.class);
                post.setUser(user);
                post.setPicture(picture);
                postRepository.save(post);
                output.add(String.format("Successfully imported Post, made by %s", user.getUsername()));
            } else {
                output.add("Invalid Post");
            }

        }
        return String.join("\n", output);
    }
}
