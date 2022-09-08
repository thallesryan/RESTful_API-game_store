package io.github.thallesryan.game_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.thallesryan.game_store.domain.JogoPedido;
import io.github.thallesryan.game_store.domain.Pedido;

@Repository
public interface JogoPedidoRepository extends JpaRepository<JogoPedido, Long>{
	
	void deleteByPedido(Pedido pedido);
}
