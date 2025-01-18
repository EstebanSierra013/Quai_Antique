package com.application.quai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.application.quai.model.dto.request.RestaurantRequest;
import com.application.quai.model.entity.Restaurant;

@Mapper(componentModel= "spring")
public interface  RestaurantRequestMapper {

  @Mapping(target = "idRestaurant", ignore = true)
  Restaurant toDomain(RestaurantRequest request);
}
