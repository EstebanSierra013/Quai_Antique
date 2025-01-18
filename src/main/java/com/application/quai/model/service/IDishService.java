package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.DishDto;
import com.application.quai.model.dto.request.DishRequest;


public interface IDishService {
  DishDto create(DishRequest Dish);
  List<DishDto> findAll();
  DishDto getById( int id );
  DishDto update(DishRequest request, int id);
  void deleteById( int id );
}
