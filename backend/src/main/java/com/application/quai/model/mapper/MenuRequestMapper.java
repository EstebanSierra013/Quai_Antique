package com.application.quai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.application.quai.model.dto.request.MenuRequest;
import com.application.quai.model.entity.Menu;


@Mapper(componentModel = "spring") 
public interface MenuRequestMapper {
  @Mapping(target = "idMenu", ignore = true)
  Menu toDomain(MenuRequest menu);  
}
