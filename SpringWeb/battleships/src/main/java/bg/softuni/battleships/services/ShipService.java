package bg.softuni.battleships.services;

import bg.softuni.battleships.models.Ship;
import bg.softuni.battleships.models.dtos.AddShipDto;
import bg.softuni.battleships.models.dtos.ShipAttackDto;
import bg.softuni.battleships.models.dtos.ShipDto;
import bg.softuni.battleships.reposiotories.CategoryRepository;
import bg.softuni.battleships.reposiotories.ShipRepository;
import bg.softuni.battleships.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Ship> getCurrentUserShips() {
        return shipRepository.findAllByUser(currentUser.getUser());
    }

    public List<Ship> getOtherUsersShips() {
        return shipRepository.findAllByUserNot(currentUser.getUser());
    }

    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }

    public void attack(ShipAttackDto shipAttackDto) {
        Optional<Ship> attacker = shipRepository.findById(shipAttackDto.getAttacker());
        Optional<Ship> defender = shipRepository.findById(shipAttackDto.getDefender());
        if (attacker.isEmpty() || defender.isEmpty()) return;

        defender.get().setHealth(defender.get().getHealth() - attacker.get().getPower());
        if (defender.get().getHealth() <= 0) shipRepository.delete(defender.get());
        else shipRepository.save(defender.get());
    }
}
