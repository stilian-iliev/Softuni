package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.Route;
import bg.softuni.pathfinder.repositories.RouteRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getMostCommented() {
        return routeRepository.findRoutesOrderedByCommentsSize().get(0);
    }
}
