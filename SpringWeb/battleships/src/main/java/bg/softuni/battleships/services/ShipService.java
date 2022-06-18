package bg.softuni.battleships.services;

import bg.softuni.battleships.models.Ship;
import bg.softuni.battleships.models.dtos.AddShipDto;
import bg.softuni.battleships.reposiotories.CategoryRepository;
import bg.softuni.battleships.reposiotories.ShipRepository;
import bg.softuni.battleships.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    private final CurrentUser currentUser;

    public ShipService(ShipRepository shipRepository, CategoryRepository categoryRepository, ModelMapper mapper, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
        this.currentUser = currentUser;
    }

    public void addShip(AddShipDto addShipDto) {
        Ship ship = mapper.map(addShipDto, Ship.class);
        ship.setCategory(categoryRepository.findByName(addShipDto.getCategory()));
        ship.setUser(currentUser.getUser());
        shipRepository.save(ship);
    }
}
