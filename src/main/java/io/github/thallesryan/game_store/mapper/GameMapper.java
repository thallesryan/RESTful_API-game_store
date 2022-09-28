package io.github.thallesryan.game_store.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import io.github.thallesryan.game_store.domain.dto.game.GameResponseDTO;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameMapper INSTANCE = Mappers.getMapper( GameMapper.class );
    
    Game toEntity(GameRequestDTO request);
    
    Game toEntity(GameResponseDTO response);
    
    GameResponseDTO toResponseDTO(Game game);
    
    List<Game> toGameList(List<GameRequestDTO> requestList);
}
