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

import com.application.quai.model.dto.request.RestaurantRequest;
import com.application.quai.model.service.IRestaurantService;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
  
  @Autowired
  private IRestaurantService restaurantService;

  @PostMapping("/")
  public ResponseEntity<?> create(@RequestBody RestaurantRequest request) {
    return ResponseEntity.ok(restaurantService.create(request));
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable int id){
    return ResponseEntity.ok(restaurantService.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody RestaurantRequest restaurant, @PathVariable int id){
    return ResponseEntity.ok(restaurantService.update(restaurant, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable int id){
    restaurantService.deleteById(id);
    return ResponseEntity.ok("Deleted Restaurant");
  }
}
