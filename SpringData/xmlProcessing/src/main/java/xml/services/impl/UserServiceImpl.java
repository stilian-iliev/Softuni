package xml.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xml.entities.user.*;
import xml.repositories.UserRepository;
import xml.services.UserService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        mapper = new ModelMapper();
    }

    @Override
    @Transactional
    public UsersWithSoldProductsListDto findAllWithSoldProducts() {
        List<User> users = userRepository.findAllOrderByLastNameAscFirstNameAsc()
                .stream().map(u -> {
                    u.setSoldProducts(u.getSoldProducts().stream().filter(p -> p.getBuyer() != null).collect(Collectors.toList()));
                    return u;
                }).filter(u -> u.getSoldProducts().size() > 0)
                .collect(Collectors.toList());

        List<UserWithSoldProductsDto> userDtos = users.stream()
                .map(u -> mapper.map(u, UserWithSoldProductsDto.class))
                .collect(Collectors.toList());

        return new UsersWithSoldProductsListDto(userDtos);
    }

    @Override
    @Transactional
    public UsersProductsCountListDto findAllUsersProductsCount() {
        List<User> users = userRepository.findAllOrderByLastNameAscFirstNameAsc()
                .stream().map(u -> {
                    u.setSoldProducts(u.getSoldProducts().stream().filter(p -> p.getBuyer() != null).collect(Collectors.toList()));
                    return u;
                }).filter(u -> u.getSoldProducts().size() > 0)
                .sorted((l, r) -> r.getSoldProducts().size() - l.getSoldProducts().size())
                .collect(Collectors.toList());

        List<UserProductsDto> userProductsDtos = users.stream()
                .map(u -> mapper.map(u, UserProductsDto.class))
                .collect(Collectors.toList());

        return new UsersProductsCountListDto(userProductsDtos);

    }
}
