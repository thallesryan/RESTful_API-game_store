package io.github.thallesryan.game_store.service;

import io.github.thallesryan.game_store.domain.Jogo;
import io.github.thallesryan.game_store.domain.dto.JogoDTO;

public interface JogoService {
	
	public void save(Jogo jogo);
	
	public void update(Jogo jogo);
	
	public void delete(Long idJogo);
	
	public Jogo findById(Long idJogo);
	

}
