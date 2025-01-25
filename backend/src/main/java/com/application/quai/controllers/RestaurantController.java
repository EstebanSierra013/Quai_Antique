package com.application.quai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.quai.model.dto.request.RestaurantRequestDto;
import com.application.quai.model.service.IRestaurantService;


@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
  
  @Autowired
  private IRestaurantService restaurantService;

  @PostMapping("/")
  public ResponseEntity<?> createRestaurant(@RequestBody RestaurantRequestDto request) {
    return ResponseEntity.ok(restaurantService.createRestaurant(request));
  }
  
  @GetMapping("/")
  public ResponseEntity<?> getAllRestaurants(){
    return ResponseEntity.ok(restaurantService.getAllRestaurants());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getRestaurantById(@PathVariable int id){
    return ResponseEntity.ok(restaurantService.getRestaurantById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateRestaurant(@RequestBody RestaurantRequestDto restaurant, @PathVariable int id){
    return ResponseEntity.ok(restaurantService.updateRestaurant(restaurant, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteRestaurant(@PathVariable int id){
    restaurantService.deleteRestaurant(id);
    return ResponseEntity.ok("Deleted Restaurant");
  }
}
