package io.github.thallesryan.game_store.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.thallesryan.game_store.domain.dto.order.OrderRequestDTO;
import io.github.thallesryan.game_store.domain.dto.order.OrderResponseDTO;
import io.github.thallesryan.game_store.domain.dto.user.UserRequestDTO;
import io.github.thallesryan.game_store.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping
	public void save(@RequestBody OrderRequestDTO request) {
		service.save(request);
	}
	
	@GetMapping("/{user_id}")
	public List<OrderResponseDTO> findOrdersByUser(@PathVariable Integer user_id) {
		return this.service.findByUserId(user_id);
		
	}
	
}
