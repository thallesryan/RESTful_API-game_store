package io.github.thallesryan.game_store.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.thallesryan.game_store.controller.GameController;
import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.InventoryControl;
import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import io.github.thallesryan.game_store.domain.dto.game.GameResponseDTO;
import io.github.thallesryan.game_store.domain.dto.order.ItemRequestDTO;
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
		
		
		GameResponseDTO gameResponse = mapper.toResponseDTO(entitySaved);
		gameResponse.add(linkTo(methodOn(GameController.class).findById(gameResponse.getId())).withSelfRel());
		return gameResponse;
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
		
		GameResponseDTO response = mapper.toResponseDTO(entity);
		response.add(linkTo(methodOn(GameController.class).findById(id)).withSelfRel());
		return response;
	}

	@Override
	public Page<GameResponseDTO> findAll(Pageable pageable) {
		GameMapper mapper = GameMapper.INSTANCE;
		Page<Game> gamesList = repository.findAll(pageable);

		return gamesList.map((game) -> mapper.toResponseDTO(game));

	}
	
	@Override
	public List<GameResponseDTO> findAvailableGames() {
		 return this.repository.findAvailableGames().stream().map(GameMapper.INSTANCE::toResponseDTO).collect(Collectors.toList());
	}
	
	@Override
	public void gamesSold(Set<ItemRequestDTO> items) {
		
		items.stream().forEach(item -> {
			Game game = this.repository.findById(item.getGame().getId()).get();
			InventoryControl inventory = game.getInventoryControl();
			inventory.sellGame(item.getQuantity());
			game.setInventoryControl(inventory);
			this.repository.save(game);
		});
		
	}

}
