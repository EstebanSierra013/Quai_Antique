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

import com.application.quai.model.dto.request.DishRequest;
import com.application.quai.model.service.IDishService;

@RestController
@RequestMapping("/dish")
public class DishController {
  
  @Autowired
  private IDishService dishService;

  @PostMapping("/")
  public ResponseEntity<?> create(@RequestBody DishRequest request) {
    return ResponseEntity.ok(dishService.create(request));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable int id){
    return ResponseEntity.ok(dishService.getById(id));
  }

  @GetMapping("/list")
  public ResponseEntity<?> findAll(){
    return ResponseEntity.ok(dishService.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody DishRequest dish, @PathVariable int id){
    return ResponseEntity.ok(dishService.update(dish, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable int id){
    dishService.deleteById(id);
    return ResponseEntity.ok("Deleted Dish");
  }
}
