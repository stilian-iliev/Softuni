package com.example.football.repository;

import com.example.football.models.dto.player.PlayerDto;
import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Player findByEmail(String email);

    @Query("select new com.example.football.models.dto.player.PlayerDto(p.firstName, p.lastName, p.position, t.name, t.stadiumName) from Player p join p.team t join p.stat s where year(p.birthDate) > 1995 and year(p.birthDate) < 2003 order by s.shooting desc, s.passing desc, s.endurance desc, p.lastName")
    List<PlayerDto> findBestPlayers();
}
