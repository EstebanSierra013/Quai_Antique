package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.RestaurantDto;
import com.application.quai.model.dto.request.RestaurantRequestDto;

public interface IRestaurantService{
  RestaurantDto createRestaurant(RestaurantRequestDto request);
  List<RestaurantDto> getAllRestaurants();
  RestaurantDto getRestaurantById(int id);
  RestaurantDto updateRestaurant(RestaurantRequestDto restaurant, int id);
  void deleteRestaurant(int id);
}

