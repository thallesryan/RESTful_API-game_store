package io.github.thallesryan.game_store.domain;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*Lombok*/
@Getter @Setter
@ToString @EqualsAndHashCode  @NoArgsConstructor 
/*Herança*/
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Categoria", length = 10, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Regular")
@Entity
public class Jogo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome não pode estar vazio.")
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Positive(message = "Preço tem que ser Positivo e maior que zero.")
	@NotNull(message = "Preço não pode estar vazio.")
	@Column(nullable = false, scale = 2)
	private Double preco;
	
	@PositiveOrZero(message = "Estoque não pode ser negativo.")
	private Integer qtdeEstoque;

	public Jogo(String nome, Double preco,int qtdeEstoque ) {
		this.setNome(nome);
		this.setPreco(preco);
		this.setQtdeEstoque(qtdeEstoque);
	}

	
}
