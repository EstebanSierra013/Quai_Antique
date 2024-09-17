package com.application.quai.model.mapper;

import org.mapstruct.Mapper;

import com.application.quai.model.dto.DishDto;
import com.application.quai.model.entity.Dish;


@Mapper(componentModel = "spring") 
public interface DishDtoMapper {  
  DishDto toDto(Dish dish);
}
