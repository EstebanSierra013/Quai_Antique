package com.application.quai.model.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.RestaurantDto;
import com.application.quai.model.dto.request.RestaurantRequest;
import com.application.quai.model.entity.Restaurant;
import com.application.quai.model.mapper.RestaurantDtoMapper;
import com.application.quai.model.mapper.RestaurantRequestMapper;
import com.application.quai.model.repository.IRestaurantRepository;
import com.application.quai.model.service.IRestaurantService;

@Service
public class RestaurantServiceImpl implements IRestaurantService{

    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantDtoMapper restaurantDtoMapper;

    @Autowired
    private RestaurantRequestMapper restaurantRequestMapper;

    public Restaurant getByRestaurant(int id){
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isEmpty()){
            System.err.println("ERROR");
        }
        return optionalRestaurant.get();
    }

    @Override
    public RestaurantDto create(RestaurantRequest request){
        Restaurant newRestaurant = restaurantRequestMapper.toDomain(request);
        Restaurant createdRestaurant = restaurantRepository.save(newRestaurant);
        return restaurantDtoMapper.toDto(createdRestaurant);
    }

    @Override
    public RestaurantDto getById(int id){
        Restaurant findRestaurant = getByRestaurant(id);
        return restaurantDtoMapper.toDto(findRestaurant);
    }

    @Override
    public RestaurantDto update(RestaurantRequest request, int id) {
        Restaurant restaurantToUpdate = this.getByRestaurant(id);
        setValuesToUpdate(request,restaurantToUpdate);
        Restaurant updatedRestaurant = restaurantRepository.save(restaurantToUpdate);
        return restaurantDtoMapper.toDto(updatedRestaurant);
    }

    private void setValuesToUpdate(RestaurantRequest request, Restaurant currentRestaurant){
        currentRestaurant.setAmOpeningTime(request.getAmOpeningTime());
        currentRestaurant.setPmOpeningTime(request.getPmOpeningTime());
        currentRestaurant.setMaxGuests(request.getMaxGuests());
    }
    
    @Override
    public void deleteById(int id){
        restaurantRepository.deleteById(id);
    }
}
