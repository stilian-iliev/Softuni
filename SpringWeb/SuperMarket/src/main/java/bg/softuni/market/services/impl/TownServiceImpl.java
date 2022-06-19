package bg.softuni.market.services.impl;

import bg.softuni.market.models.entities.Town;
import bg.softuni.market.repositories.TownRepository;
import bg.softuni.market.services.TownService;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void addTown(String name) {

        townRepository.save(new Town(name));
        System.out.println("Successfully added town!");
    }
}
