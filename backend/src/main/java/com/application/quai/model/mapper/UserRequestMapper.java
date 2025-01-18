package com.application.quai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.application.quai.model.dto.request.UserRequest;
import com.application.quai.model.entity.User;


@Mapper(componentModel = "spring") 
public interface UserRequestMapper {

  @Mapping(target = "rol", ignore = true)
  @Mapping(target = "reservationList", ignore = true)
  User toDomain(UserRequest user);
}
