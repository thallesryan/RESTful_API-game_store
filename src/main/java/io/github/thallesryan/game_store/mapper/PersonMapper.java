package io.github.thallesryan.game_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import io.github.thallesryan.game_store.domain.Person;
import io.github.thallesryan.game_store.domain.dto.PersonRequestDTO;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );
    
    Person toEntity(PersonRequestDTO request);
    
//    PersonRequestDTO toResponseDTO(Person person);
    
   
}

