package io.github.thallesryan.game_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.thallesryan.game_store.domain.dto.order.OrderRequestDTO;
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
	
}
