package com.application.quai.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.application.quai.model.dto.DishDto;
import com.application.quai.model.dto.request.DishRequestDto;


public interface IDishService {
  DishDto createDish(DishRequestDto Dish, MultipartFile imageFile) throws IOException;
  List<DishDto> getAllDishes();
  DishDto getDishById( int id );
  List<DishDto> getDishByCategory (String categoryName);
  DishDto updateDish(DishRequestDto request, MultipartFile imageFile, int id) throws IOException;
  void deleteDish( int id );  
}
