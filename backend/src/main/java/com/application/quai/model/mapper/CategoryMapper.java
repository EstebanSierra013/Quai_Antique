package com.application.quai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.application.quai.model.dto.CategoryDto;
import com.application.quai.model.dto.request.CategoryRequestDto;
import com.application.quai.model.entity.Category;



@Mapper(componentModel = "spring") 
public interface CategoryMapper {

  @Mapping(target="dishList", ignore = true)
  @Mapping(target="idCategory", ignore = true)
  Category toEntity(CategoryRequestDto dish);

  CategoryDto toDto(Category dish);
}
