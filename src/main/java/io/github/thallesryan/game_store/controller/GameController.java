package io.github.thallesryan.game_store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import io.github.thallesryan.game_store.domain.dto.game.GameResponseDTO;
import io.github.thallesryan.game_store.mapper.GameMapper;
import io.github.thallesryan.game_store.service.GameServiceImpl;

@RestController
@RequestMapping("admin/games")

public class GameController {
	
	@Autowired
	GameServiceImpl jogoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Valid GameRequestDTO game) {
		Game entity = GameMapper.INSTANCE.toEntity(game);
		jogoService.save(entity);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Game game){
		Game gameEncontrado = jogoService.findById(id);
		gameEncontrado.setNome(game.getNome());
		gameEncontrado.setPreco(game.getPreco());
		gameEncontrado.setQtdeEstoque(game.getQtdeEstoque());
		jogoService.save(gameEncontrado);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Game buscarJogoPeloId(@PathVariable Long id) {

		return jogoService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void deletarJogo(@PathVariable Long id) {
		jogoService.delete(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public ResponseEntity<Page<GameResponseDTO>> findAll(@RequestParam(value = "page", defaultValue = "0")Integer page, @RequestParam(value = "size", defaultValue = "12")Integer size){
		
		Pageable pagable = PageRequest.of(page, size);
		return ResponseEntity.ok(jogoService.findAll(pagable));
	}
	
	
}
