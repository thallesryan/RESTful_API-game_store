package io.github.thallesryan.game_store.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import io.github.thallesryan.game_store.domain.dto.game.GameResponseDTO;
import io.github.thallesryan.game_store.mapper.GameMapper;
import io.github.thallesryan.game_store.service.GameServiceImpl;

@RestController
@RequestMapping("admin/games")

public class GameController {
	
	@Autowired
	GameServiceImpl gameService;
	
	@PostMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<GameResponseDTO> salvar(@RequestBody @Valid GameRequestDTO game) {
		
		GameResponseDTO gameResponse = gameService.save(game);
		return ResponseEntity.ok(gameResponse);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody GameRequestDTO game){
		GameResponseDTO gameEncontrado = gameService.findById(id);
		gameEncontrado.setName(game.getName());
		gameEncontrado.setPrice(game.getPrice());
		gameEncontrado.setQuantity(game.getQuantity());
		gameService.update(gameEncontrado);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameResponseDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(gameService.findById(id));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void deletarJogo(@PathVariable Integer id) {
		gameService.delete(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public ResponseEntity<Page<GameResponseDTO>> findAll(@RequestParam(value = "page", defaultValue = "0")Integer page, @RequestParam(value = "size", defaultValue = "12")Integer size){
		Pageable pagable = PageRequest.of(page, size);
		return ResponseEntity.ok(gameService.findAll(pagable));
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/available")
	public List<GameResponseDTO> gamesAvailable() {
		return this.gameService.findAvailableGames();
	}
}
