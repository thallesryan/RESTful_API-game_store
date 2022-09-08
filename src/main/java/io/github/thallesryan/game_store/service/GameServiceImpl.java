package io.github.thallesryan.game_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.dto.game.GameResponseDTO;
import io.github.thallesryan.game_store.exception.GameNotFoundException;
import io.github.thallesryan.game_store.mapper.GameMapper;
import io.github.thallesryan.game_store.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameRepository repository;

	@Override
	public void save(Game game) {

		this.repository.save(game);
	}

	@Override
	public void update(Game jogo) {
		repository.save(jogo);
	}

	@Override
	public void delete(Long idjogo) {

		Game gameEncontrado = repository.findById(idjogo).orElseThrow(() -> new GameNotFoundException());
		repository.delete(gameEncontrado);
	}

	@Override
	public Game findById(Long idJogo) {

		return repository.findById(idJogo).orElseThrow(() -> new GameNotFoundException());
	}

	@Override
	public Page<GameResponseDTO> findAll(Pageable pageable) {
		GameMapper mapper = GameMapper.INSTANCE;
		Page<Game> gamesList = repository.findAll(pageable);

		return gamesList.map((game) -> mapper.toResponseDTO(game));

	}

}
