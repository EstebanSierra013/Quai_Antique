package com.application.quai.model.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.application.quai.model.dto.RoleDto;
import com.application.quai.model.dto.request.RoleRequestDto;
import com.application.quai.model.entity.Role;


@Mapper(componentModel = "spring") 
public interface RoleMapper {

  @Mapping(target = "userList", ignore=true)
  @Mapping(target = "idRole", ignore=true)
  Role toEntity(RoleRequestDto dish);

  RoleDto toDto(Role dish);

  @Mapping(target = "userList", ignore=true)
  @Mapping(target = "idRole", ignore=true)
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntityFromRequest(RoleRequestDto roleRequestDto, @MappingTarget Role existingRole);
}
