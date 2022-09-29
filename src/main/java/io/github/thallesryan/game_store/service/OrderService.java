package io.github.thallesryan.game_store.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import io.github.thallesryan.game_store.domain.Order;
import io.github.thallesryan.game_store.domain.UserModel;
import io.github.thallesryan.game_store.domain.dto.order.OrderRequestDTO;
import io.github.thallesryan.game_store.domain.dto.order.OrderResponseDTO;
import io.github.thallesryan.game_store.mapper.OrderMapper;
import io.github.thallesryan.game_store.repository.OrderRepository;
import io.github.thallesryan.game_store.repository.UserRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private UserRepository userRepository;

	public void save(OrderRequestDTO orderRequest) {
		Order entity = OrderMapper.INSTANCE.toEntity(orderRequest);
		UserModel user = userRepository.findById(orderRequest.getUser().getId())
				.orElseThrow(() -> new BadCredentialsException("Usuário não encontrado!"));
		entity.setUser(user);

		repository.save(entity);
	}

	public List<OrderResponseDTO> findByUserId(Integer id) {
		UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User não encontrado"));
		Function<Order, OrderResponseDTO> orderToResponse = order -> OrderMapper.INSTANCE.toResponseDTO(order);
		return this.repository.findByUser(user).stream().map(orderToResponse).collect(Collectors.toList());
	}
}
