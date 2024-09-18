package com.application.quai.model.mapper;

import org.mapstruct.Mapper;

import com.application.quai.model.dto.MenuDto;
import com.application.quai.model.entity.Menu;


@Mapper(componentModel = "spring") 
public interface MenuDtoMapper {  
  MenuDto toDto(Menu Menu);
}
