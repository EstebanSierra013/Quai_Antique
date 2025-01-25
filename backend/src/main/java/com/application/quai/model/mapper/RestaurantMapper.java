package com.application.quai.model.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.application.quai.model.dto.RestaurantDto;
import com.application.quai.model.dto.request.RestaurantRequestDto;
import com.application.quai.model.entity.Restaurant;


@Mapper(componentModel = "spring") 
public interface RestaurantMapper {

  @Mapping(target = "idRestaurant", ignore = true)
  Restaurant toEntity(RestaurantRequestDto request);
  
  RestaurantDto toDto(Restaurant restaurant);

  @Mapping(target = "idRestaurant", ignore = true)
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntityFromRequest(RestaurantRequestDto restaurantRequestDto, @MappingTarget Restaurant existingRestaurant);
  
}
