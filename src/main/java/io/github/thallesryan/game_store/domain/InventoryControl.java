package io.github.thallesryan.game_store.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor
public class InventoryControl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(mappedBy = "inventoryControl" )
	private Game game;
	
	private Integer stock;
	
	private Integer quantitiesSold;

	public InventoryControl(Game game, Integer stock, Integer quantitiesSold) {
		super();
		this.game = game;
		this.stock = stock;
		this.quantitiesSold = quantitiesSold;
	}

	public InventoryControl(Integer stock, Integer quantitiesSold) {
		super();
		this.stock = stock;
		this.quantitiesSold = quantitiesSold;
	}

	public InventoryControl(Integer stock) {
		super();
		this.stock = stock;
	}
	
	public void addStock(Integer n) {
		this.stock += n;
	}
	
	public void addQuantitySold(Integer n) {
		this.quantitiesSold += n;
	}


}
