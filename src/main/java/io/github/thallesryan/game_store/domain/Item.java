package io.github.thallesryan.game_store.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import io.github.thallesryan.game_store.domain.dto.order.ItemRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Game game;
	
	private Integer quantity;

	public Item(Game game, Integer quantity) {
		super();
		this.game = game;
		this.quantity = quantity;
	}
	
	
}
