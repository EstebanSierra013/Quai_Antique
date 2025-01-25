package com.application.quai.model.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.application.quai.model.dto.MenuDto;
import com.application.quai.model.dto.request.MenuRequestDto;
import com.application.quai.model.entity.Menu;


@Mapper(componentModel = "spring") 
public interface MenuMapper {  
   
  @Mapping(target = "idMenu", ignore = true)
  Menu toEntity(MenuRequestDto menu);  

  MenuDto toDto(Menu Menu);

  @Mapping(target = "idMenu", ignore = true)
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntityFromRequest(MenuRequestDto menuDto, @MappingTarget Menu existingMenu);
}
