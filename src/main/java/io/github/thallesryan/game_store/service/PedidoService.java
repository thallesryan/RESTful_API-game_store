package io.github.thallesryan.game_store.service;

import io.github.thallesryan.game_store.domain.dto.PedidoDTO;

public interface PedidoService {

	void salvar(PedidoDTO pedidoDTO);
	
	void update(Long id, PedidoDTO pedidoDTO);
	
	void deletar(Long id);
	
	PedidoDTO findById(Long id);
}
