package io.github.thallesryan.game_store.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "orders")
@Data @AllArgsConstructor @NoArgsConstructor
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date = LocalDate.now(); 
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "orders_itens")
	private Set<Item> itens;
	
	private Double total;

	public Order(Set<Item> itens) {
		super();
		this.itens = itens;
		calcTotal();
	
	}
	
	private void calcTotal() {
		Double orderValue = this.itens.stream().map(item -> item.getGame().getPrice() * item.getQuantity()).reduce(0D, Double::sum);
		this.setTotal(orderValue);  
	}
	
}
