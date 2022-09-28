package io.github.thallesryan.game_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.thallesryan.game_store.domain.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{
	
	List<Game> findByQuantityGreaterThan(Integer value);

}
