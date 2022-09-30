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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "orders")
@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date = LocalDate.now(); 
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	private UserModel user;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "orders_itens")
	private Set<Item> items;
	
	private Double total;

	public Order(UserModel user, Set<Item> itens) {
		super();
		this.setUser(user);
		this.items = itens;
	}

	public Order(UserModel user, Set<Item> items, Double total) {
		super();
		this.user = user;
		this.items = items;
		this.total = total;
	}
	
	
	
	
}
