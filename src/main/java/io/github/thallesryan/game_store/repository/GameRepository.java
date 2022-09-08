package io.github.thallesryan.game_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.thallesryan.game_store.domain.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
