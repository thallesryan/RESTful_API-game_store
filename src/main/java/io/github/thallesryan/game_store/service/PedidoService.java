package io.github.thallesryan.game_store.service;

import io.github.thallesryan.game_store.domain.dto.PedidoDTO;

public interface PedidoService {

	public void salvar(PedidoDTO pedidoDTO);
	
	public void update(Long id, PedidoDTO pedidoDTO);
	
	public void deletar(Long id);
	
	public PedidoDTO findById(Long id);
}
