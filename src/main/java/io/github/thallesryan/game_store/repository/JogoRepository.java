package io.github.thallesryan.game_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.thallesryan.game_store.domain.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

}
