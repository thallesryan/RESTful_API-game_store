package io.github.thallesryan.game_store.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 {
 	"jogosPedido":[
 		{
 			"jogoId": ,
 			"quantidade":
 		}
 	],
 	"total":

 } 
 */
@Getter @Setter @EqualsAndHashCode @ToString @AllArgsConstructor @NoArgsConstructor
public class PedidoDTO {
	
	private List<JogoPedidoDTO> jogosPedido;
	private Double total;
	
}
