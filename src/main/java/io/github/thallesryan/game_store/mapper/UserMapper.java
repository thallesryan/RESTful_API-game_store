package io.github.thallesryan.game_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import io.github.thallesryan.game_store.domain.UserModel;
import io.github.thallesryan.game_store.domain.dto.user.UserRequestDTO;
import io.github.thallesryan.game_store.domain.dto.user.UserResponseDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    
    UserModel toEntity(UserRequestDTO request);
    
    UserResponseDTO toResponseDTO(UserModel person);
    
   
}

