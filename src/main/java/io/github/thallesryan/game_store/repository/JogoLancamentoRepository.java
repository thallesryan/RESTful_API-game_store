package io.github.thallesryan.game_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.thallesryan.game_store.domain.JogoLancamento;

@Repository
public interface JogoLancamentoRepository extends JpaRepository<JogoLancamento, Long>{
	
	
}
