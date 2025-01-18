package com.application.quai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.application.quai.model.dto.request.RolRequest;
import com.application.quai.model.entity.Rol;


@Mapper(componentModel = "spring") 
public interface RolRequestMapper {

  @Mapping(target = "idRol", ignore = true)
  @Mapping(target = "userList", ignore = true)
  Rol toDomain(RolRequest rol);  
}
