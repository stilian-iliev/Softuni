package softuni.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.gamestore.entities.game.Game;
import softuni.gamestore.entities.game.GameSummaryDto;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Game findById(int id);

//    @Query("select g.title as title, g.price as price from Game g")
    List<GameSummaryDto> findAllByIdGreaterThan(int id);

    Game findFirstByTitle(String title);

}
