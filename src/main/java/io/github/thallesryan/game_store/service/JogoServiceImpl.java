package io.github.thallesryan.game_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.thallesryan.game_store.domain.Jogo;
import io.github.thallesryan.game_store.domain.dto.JogoDTO;
import io.github.thallesryan.game_store.exception.JogoNaoEncontradoException;
import io.github.thallesryan.game_store.repository.JogoRepository;

@Service
public class JogoServiceImpl implements JogoService{

	@Autowired
	JogoRepository repository;
	
	@Override
	public void save(Jogo jogo) {
		
		this.repository.save(jogo);
	}

	@Override
	public void update(Jogo jogo) {
		repository.save(jogo);
	}

	@Override
	public void delete(Long idjogo) {
		
		Jogo jogoEncontrado =  repository.findById(idjogo).orElseThrow(() -> new JogoNaoEncontradoException());
		repository.delete(jogoEncontrado);
	}

	@Override
	public Jogo findById(Long idJogo) {

		return repository.findById(idJogo).orElseThrow(() -> new JogoNaoEncontradoException());
	}
	
	
}
