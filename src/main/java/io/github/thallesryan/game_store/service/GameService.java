package io.github.thallesryan.game_store.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import io.github.thallesryan.game_store.domain.dto.game.GameResponseDTO;

public interface GameService {
	
	GameResponseDTO save(GameRequestDTO game);
	
	void update(Game game);
	
	void delete(Long idJogo);
	
	Game findById(Long idJogo);
	
	Page<GameResponseDTO> findAll(Pageable pageable);

}
