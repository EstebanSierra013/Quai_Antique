package com.application.quai.model.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.application.quai.model.dto.DishDto;
import com.application.quai.model.dto.request.DishRequestDto;
import com.application.quai.model.entity.Dish;


@Mapper(componentModel = "spring") 
public interface DishMapper {

  @Mapping(target = "imageUrl", source = "image.url")
  DishDto toDto(Dish dish);

  @Mapping(target = "idDish", ignore = true)
  @Mapping(target = "image", ignore = true)
  @Mapping(target = "category", ignore = true)
  Dish toEntity(DishRequestDto dish);  

  @Mapping(target = "idDish", ignore = true)
  @Mapping(target = "image", ignore = true)
  @Mapping(target = "category", ignore = true)
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntityFromRequest(DishRequestDto dishDto, @MappingTarget Dish existingDish);
}
