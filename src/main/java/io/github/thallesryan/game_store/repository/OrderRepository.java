package io.github.thallesryan.game_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.thallesryan.game_store.domain.Order;
import io.github.thallesryan.game_store.domain.UserModel;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	List<Order>findByUser(UserModel user);
}
