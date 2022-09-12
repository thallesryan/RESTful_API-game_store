package io.github.thallesryan.game_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.thallesryan.game_store.domain.Order;
import io.github.thallesryan.game_store.domain.dto.order.OrderRequestDTO;
import io.github.thallesryan.game_store.mapper.OrderMapper;
import io.github.thallesryan.game_store.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;

	public void save(OrderRequestDTO orderRequest) {
		Order entity = OrderMapper.INSTANCE.toEntity(orderRequest);
		repository.save(entity);
	}
}
