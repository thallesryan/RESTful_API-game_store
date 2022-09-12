package io.github.thallesryan.game_store.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.Item;
import io.github.thallesryan.game_store.domain.Order;
import io.github.thallesryan.game_store.repository.GameRepository;
import io.github.thallesryan.game_store.repository.OrderRepository;

@Service
public class DBService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	 
	public void instantiateDB() {
		
		Game game = new Game("The Last Of Us", 200D, 15);
		Game game2 = new Game("Red Dead Redemption 2", 175D, 10);
		Game game3 = new Game("Hollow Knight", 50D, 12);
		
		gameRepository.saveAll(List.of(game, game2, game3));
		
		Order order = new Order(Set.of(new Item(game, 1), new Item(game2, 1)));
		orderRepository.save(order);
	}
}
