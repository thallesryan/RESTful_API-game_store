package io.github.thallesryan.game_store.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.thallesryan.game_store.domain.dto.PedidoDTO;
import io.github.thallesryan.game_store.repository.PedidoRepository;
import io.github.thallesryan.game_store.service.PedidoServiceImp;

@RestController
@RequestMapping("/gamestore/pedido")
public class PedidoController {

	@Autowired
	PedidoServiceImp pedidoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody PedidoDTO pedidodto) {
		pedidoService.salvar(pedidodto);
	}
	
	@PutMapping("/{id}")
	public void atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
		pedidoService.update(id, pedidoDTO);
	}
	
}
