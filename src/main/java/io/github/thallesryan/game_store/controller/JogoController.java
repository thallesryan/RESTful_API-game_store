package io.github.thallesryan.game_store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.thallesryan.game_store.domain.Jogo;
import io.github.thallesryan.game_store.domain.dto.JogoDTO;
import io.github.thallesryan.game_store.service.JogoServiceImpl;

@RestController
@RequestMapping("gamestore/jogo")

public class JogoController {
	
	@Autowired
	JogoServiceImpl jogoService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Valid Jogo jogo) {
		
		jogoService.save(jogo);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Jogo jogo){
		Jogo jogoEncontrado = jogoService.findById(id);
		jogoEncontrado.setNome(jogo.getNome());
		jogoEncontrado.setPreco(jogo.getPreco());
		jogoEncontrado.setQtdeEstoque(jogo.getQtdeEstoque());
		jogoService.save(jogoEncontrado);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Jogo buscarJogoPeloId(@PathVariable Long id) {
		
		return jogoService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void deletarJogo(@PathVariable Long id) {
		jogoService.delete(id);
	}
	
}
