package xml.processing.productshop.services.impl;

import xml.processing.productshop.entities.user.User;
import xml.processing.productshop.entities.user.UserWithSoldProductsDto;
import xml.processing.productshop.entities.user.UsersProductsSummary;
import xml.processing.productshop.repositories.UserRepository;
import xml.processing.productshop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private ModelMapper mapper = new ModelMapper();
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    @Transactional
    public List<UserWithSoldProductsDto> findAllUsersWithSoldProducts() {
        List<User> allWithSoldItems = userRepository.findAllWithSoldItems();
        return userRepository.findAllWithSoldItems()
                .stream().map(u -> mapper.map(u, UserWithSoldProductsDto.class))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public UsersProductsSummary findUsersSoldProductsSummary() {
        List<User> dto = userRepository.findAllUsersAndProducts();
        UsersProductsSummary summary = new UsersProductsSummary(dto, mapper);

        return summary;
    }
}
