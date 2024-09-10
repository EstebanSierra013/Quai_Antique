package com.application.quai.model.service;

import com.application.quai.model.dto.RestaurantDto;
import com.application.quai.model.dto.request.RestaurantRequest;

public interface IRestaurantService{
  RestaurantDto create(RestaurantRequest request);
  RestaurantDto getById(int id);
  RestaurantDto update(RestaurantRequest restaurant, int id);
  void deleteById(int id);
}

