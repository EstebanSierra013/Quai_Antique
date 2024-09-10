package com.application.quai.model.mapper;

import org.mapstruct.Mapper;

import com.application.quai.model.dto.RestaurantDto;
import com.application.quai.model.entity.Restaurant;


@Mapper(componentModel = "spring") 
public interface RestaurantDtoMapper {
  RestaurantDto toDto(Restaurant restaurant);
}
