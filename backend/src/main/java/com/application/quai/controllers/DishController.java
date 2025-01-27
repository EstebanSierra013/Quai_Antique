package com.application.quai.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.quai.model.dto.request.DishRequestDto;
import com.application.quai.model.service.IDishService;

@RestController
@RequestMapping("/dishes")
@CrossOrigin("http://localhost:4200/")
public class DishController {
  
  @Autowired
  private IDishService dishService;

  @PostMapping("/")
  public ResponseEntity<?> createDish(@RequestPart DishRequestDto request, @RequestPart MultipartFile imageFile) {
    try{
      return ResponseEntity.ok(dishService.createDish(request, imageFile));
    }catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen: " + e.getMessage());
    }    
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getDishById(@PathVariable int id){
    return ResponseEntity.ok(dishService.getDishById(id));
  }

  @GetMapping("/")
  public ResponseEntity<?> getAllDishes(){
    return ResponseEntity.ok(dishService.getAllDishes());
  }

  @GetMapping("/category/{category}")
  public ResponseEntity<?> getDishByCategory(@PathVariable String category){
    return ResponseEntity.ok(dishService.getDishByCategory(category));
  }


  @PutMapping("/{id}")
  public ResponseEntity<?> updateDish(@RequestPart DishRequestDto request, @RequestPart MultipartFile imageFile, @PathVariable int id){
    try{
      return ResponseEntity.ok(dishService.updateDish(request, imageFile, id));
    }catch(IOException e){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen: " + e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteDish(@PathVariable int id){
    dishService.deleteDish(id);
    return ResponseEntity.ok("Deleted Dish");
  }
}
