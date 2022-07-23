package io.github.thallesryan.game_store.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.github.thallesryan.game_store.domain.Jogo;
import io.github.thallesryan.game_store.domain.JogoPedido;
import io.github.thallesryan.game_store.domain.Pedido;
import io.github.thallesryan.game_store.domain.dto.JogoPedidoDTO;
import io.github.thallesryan.game_store.domain.dto.PedidoDTO;
import io.github.thallesryan.game_store.exception.PedidoNaoEncontradoException;
import io.github.thallesryan.game_store.repository.JogoPedidoRepository;
import io.github.thallesryan.game_store.repository.PedidoRepository;

@Repository
public class PedidoServiceImp implements PedidoService{
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	JogoPedidoRepository jogoPedidoRepository;
	
	@Autowired
	JogoServiceImpl jogoService;
	
	@Override
	public void salvar(PedidoDTO pedidoDTO) {
		
		List<JogoPedidoDTO> jogosPedidoDTO = pedidoDTO.getJogosPedido();
		Pedido pedido = new Pedido();
		
		List<JogoPedido> jogos = this.converterJogosPedidoDTO(jogosPedidoDTO, pedido);
		
		pedido.setJogos(jogos);
		pedido.setTotal(pedidoDTO.getTotal());
		pedido.setData(LocalDate.now());
		
		pedidoRepository.save(pedido);
	}

	@Override @Transactional
	public void update(Long id, PedidoDTO pedidoDTO) {

		Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new PedidoNaoEncontradoException());
		List<JogoPedido> jogosUpdate = this.converterJogosPedidoDTO(pedidoDTO.getJogosPedido(), pedido);
		
		jogoPedidoRepository.deleteByPedido(pedido);
		
		
		pedido.setTotal(pedidoDTO.getTotal());
		pedido.setJogos(jogosUpdate);
		pedidoRepository.save(pedido);
		
	}

	@Override
	public void deletar(Long id) {
		
		Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new PedidoNaoEncontradoException());
		
	}

	@Override
	public PedidoDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<JogoPedido> converterJogosPedidoDTO(List<JogoPedidoDTO> jogosPedidoDTO, Pedido pedido) {		
		return	jogosPedidoDTO.stream().map(itemPedidoDTO -> {
			Long idJogo = itemPedidoDTO.getJogoId();
			Jogo jogo = jogoService.findById(idJogo);
			
			JogoPedido pedidoItem = new JogoPedido();
			pedidoItem.setJogo(jogo);
			pedidoItem.setQtde(itemPedidoDTO.getQuantidade());
			pedidoItem.setPedido(pedido);
			
			return pedidoItem;
		}).collect(Collectors.toList());
		
	}
}
