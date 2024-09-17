package com.application.quai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.application.quai.model.dto.request.DishRequest;
import com.application.quai.model.entity.Dish;


@Mapper(componentModel = "spring") 
public interface DishRequestMapper {
  @Mapping(target = "idDish", ignore = true)
  @Mapping(target = "imageId", ignore = true)
  @Mapping(target = "category", ignore = true)
  Dish toDomain(DishRequest dish);

  
}
