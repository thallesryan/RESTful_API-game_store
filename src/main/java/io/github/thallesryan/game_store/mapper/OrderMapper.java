package io.github.thallesryan.game_store.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.Order;
import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import io.github.thallesryan.game_store.domain.dto.order.OrderRequestDTO;
import io.github.thallesryan.game_store.domain.dto.order.OrderResponseDTO;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );
    
    Order toEntity(OrderRequestDTO request);
    
    OrderResponseDTO toResponseDTO(Order order);
    
}