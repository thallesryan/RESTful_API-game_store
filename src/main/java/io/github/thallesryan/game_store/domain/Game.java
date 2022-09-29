package io.github.thallesryan.game_store.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import io.github.thallesryan.game_store.domain.enums.GameGenre;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*Lombok*/
@Getter @Setter
@ToString @EqualsAndHashCode  @NoArgsConstructor @AllArgsConstructor

/*Herança*/
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Categoria", length = 10, discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("Regular")

@Entity
public class Game implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Column(nullable = false, scale = 2)
	private Double price;
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private InventoryControl inventoryControl;

	@Column(name = "Gênero")
	@Enumerated(EnumType.STRING)
	private GameGenre genre;

	public Game(String name, Double price, int quantity ) {
		this.setName(name);
		this.setPrice(price);
		//this.setQuantity(quantity);
	}
	
	public Game(String name, Double price,GameGenre genre, InventoryControl inventoryControl ) {
		this.setName(name);
		this.setPrice(price);
		this.setGenre(genre);	
		this.setInventoryControl(inventoryControl);
	}


}
