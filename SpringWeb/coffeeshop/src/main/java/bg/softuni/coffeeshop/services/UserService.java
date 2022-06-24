package bg.softuni.coffeeshop.services;

import bg.softuni.coffeeshop.models.dtos.EmployeeDto;
import bg.softuni.coffeeshop.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<EmployeeDto> getAllDtos() {
        return userRepository.findAll()
                .stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }
}
