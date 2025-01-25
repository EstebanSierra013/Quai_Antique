package com.application.quai.model.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.application.quai.model.dto.UserDto;
import com.application.quai.model.dto.request.UserRequestDto;
import com.application.quai.model.entity.User;


@Mapper(componentModel = "spring", uses = {ReservationMapper.class})
public interface UserMapper {

    @Mapping(target = "email", source = "email")
    @Mapping(target = "reservationList", ignore = true)
    @Mapping(target = "role", ignore = true)  
    User toEntity(UserRequestDto userRequestDto);

    @Mapping(target = "roleName", source = "role.name")
    UserDto toDto(User user);

    List<UserDto> toUserDtoList(List<User> users);

    @Mapping(target = "reservationList", ignore = true)
    @Mapping(target = "role", ignore = true)  
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(UserRequestDto userRequestDto, @MappingTarget User existingUser);

}