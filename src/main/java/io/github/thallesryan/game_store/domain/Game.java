package io.github.thallesryan.game_store.domain;

import java.io.Serializable;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import io.github.thallesryan.game_store.domain.enums.GameGenre;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*Lombok*/
@Getter @Setter
@ToString @EqualsAndHashCode  @NoArgsConstructor 

/*Herança*/
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Categoria", length = 10, discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("Regular")

@Entity
public class Game implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(nullable = false, scale = 2)
	private Double preco;
	
	private Integer qtdeEstoque;

	@Column(name = "Gênero")
	@Enumerated(EnumType.STRING)
	private GameGenre genre;

	public Game(String nome, Double preco, int qtdeEstoque ) {
		this.setNome(nome);
		this.setPreco(preco);
		this.setQtdeEstoque(qtdeEstoque);
	}
}
