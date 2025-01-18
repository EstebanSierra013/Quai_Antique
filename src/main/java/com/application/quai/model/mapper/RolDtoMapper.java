package com.application.quai.model.mapper;

import org.mapstruct.Mapper;

import com.application.quai.model.dto.RolDto;
import com.application.quai.model.entity.Rol;


@Mapper(componentModel = "spring") 
public interface RolDtoMapper {
  RolDto toDto(Rol user);
}
