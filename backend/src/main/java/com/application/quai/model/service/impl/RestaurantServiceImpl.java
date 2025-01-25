package com.application.quai.model.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.RestaurantDto;
import com.application.quai.model.dto.request.RestaurantRequestDto;
import com.application.quai.model.entity.Restaurant;
import com.application.quai.model.mapper.RestaurantMapper;
import com.application.quai.model.repository.IRestaurantRepository;
import com.application.quai.model.service.IRestaurantService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RestaurantServiceImpl implements IRestaurantService{

    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Override
    public RestaurantDto createRestaurant(RestaurantRequestDto request){
        Restaurant newRestaurant = restaurantMapper.toEntity(request);
        Restaurant createdRestaurant = restaurantRepository.save(newRestaurant);
        return restaurantMapper.toDto(createdRestaurant);
    }

    @Override
    public List<RestaurantDto> getAllRestaurants(){
        List<Restaurant> listRestaurant = restaurantRepository.findAll();
        return listRestaurant.stream()
        .map((Restaurant) -> restaurantMapper.toDto(Restaurant))
        .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto getRestaurantById(int id){
        Restaurant findRestaurant = restaurantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
        return restaurantMapper.toDto(findRestaurant);
    }

    @Override
    public RestaurantDto updateRestaurant(RestaurantRequestDto request, int id) {
        Restaurant existingRestaurant = restaurantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
        restaurantMapper.updateEntityFromRequest(request,existingRestaurant);
        Restaurant updatedRestaurant = restaurantRepository.save(existingRestaurant);
        return restaurantMapper.toDto(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(int id){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
        restaurantRepository.delete(restaurant);
    }
}
