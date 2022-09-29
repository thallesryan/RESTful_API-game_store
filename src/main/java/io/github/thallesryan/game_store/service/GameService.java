package io.github.thallesryan.game_store.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import io.github.thallesryan.game_store.domain.dto.game.GameResponseDTO;
import io.github.thallesryan.game_store.domain.dto.order.ItemRequestDTO;

public interface GameService {
	
	GameResponseDTO save(GameRequestDTO game);
	
	void update(GameResponseDTO game);
	
	void delete(Integer id);
	
	GameResponseDTO findById(Integer id);
	
	Page<GameResponseDTO> findAll(Pageable pageable);
	
	List<GameResponseDTO> findAvailableGames();
	
	void gamesSold(Set<ItemRequestDTO> items);


}
