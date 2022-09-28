package io.github.thallesryan.game_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import io.github.thallesryan.game_store.domain.dto.game.GameResponseDTO;
import io.github.thallesryan.game_store.exception.GameNotFoundException;
import io.github.thallesryan.game_store.mapper.GameMapper;
import io.github.thallesryan.game_store.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameRepository repository;

	@Override
	public GameResponseDTO save(GameRequestDTO game) {
		GameMapper mapper = GameMapper.INSTANCE;
		Game entitytoSave = mapper.toEntity(game);
		Game entitySaved = this.repository.save(entitytoSave);
		return mapper.toResponseDTO(entitySaved);
	}

	@Override
	public void update(GameResponseDTO gameEncontrado) {
		repository.save(GameMapper.INSTANCE.toEntity(gameEncontrado));
	}

	@Override
	public void delete(Integer id) {

		Game found = repository.findById(id).orElseThrow(() -> new GameNotFoundException());
		repository.delete(found);
	}

	@Override
	public GameResponseDTO findById(Integer id) {
		GameMapper mapper = GameMapper.INSTANCE;
		
		Game entity = repository.findById(id).orElseThrow(() -> new GameNotFoundException());
		return mapper.toResponseDTO(entity);
	}

	@Override
	public Page<GameResponseDTO> findAll(Pageable pageable) {
		GameMapper mapper = GameMapper.INSTANCE;
		Page<Game> gamesList = repository.findAll(pageable);

		return gamesList.map((game) -> mapper.toResponseDTO(game));

	}
	
	@Override
	public List<Game> findAvailableGames() {
		this.repository.findByQuantityGreaterThan(0);
		return null;
	}

}
