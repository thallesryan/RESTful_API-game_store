package io.github.thallesryan.game_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.thallesryan.game_store.domain.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

@Query(nativeQuery = true, value = "select * from game where (select stock from inventory_control where id = game.inventory_control_id and stock > 0)")
	List<Game> findAvailableGames();
}
