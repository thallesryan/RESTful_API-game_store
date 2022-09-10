package io.github.thallesryan.game_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import io.github.thallesryan.game_store.domain.dto.security.UserModelDTO;
import io.github.thallesryan.game_store.domain.security.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

	
	UserModel toEntity(UserModelDTO request);
		    
	UserModelDTO toResponseDTO(UserModel user);
		    
	
	
}
