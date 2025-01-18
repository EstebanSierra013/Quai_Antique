package com.application.quai.model.mapper;

import org.mapstruct.Mapper;

import com.application.quai.model.dto.UserDto;
import com.application.quai.model.entity.User;


@Mapper(componentModel = "spring") 
public interface UserDtoMapper {
  UserDto toDto(User user);
}
