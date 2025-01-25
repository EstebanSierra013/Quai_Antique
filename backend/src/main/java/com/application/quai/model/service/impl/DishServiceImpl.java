package com.application.quai.model.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.quai.model.dto.DishDto;
import com.application.quai.model.dto.request.DishRequestDto;
import com.application.quai.model.entity.Category;
import com.application.quai.model.entity.Dish;
import com.application.quai.model.entity.Image;
import com.application.quai.model.mapper.DishMapper;
import com.application.quai.model.repository.ICategoryRepository;
import com.application.quai.model.repository.IDishRepository;
import com.application.quai.model.service.IDishService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DishServiceImpl implements IDishService {

  @Autowired
  private IDishRepository dishRepository;

  @Autowired
  private ICategoryRepository categoryRepository;

  @Autowired
  private DishMapper dishMapper;

  @Autowired
  private ImageServiceImpl imageService;

  @Override
  public DishDto createDish(DishRequestDto request, MultipartFile imageFile) throws IOException{

    Dish newDish = dishMapper.toEntity(request);

    Image newImage = imageService.uploadImage(imageFile);

    Category categoryDish = categoryRepository.findByName(request.getCategory())
    .orElseThrow(() -> new EntityNotFoundException("Category not found"));

    newDish.setImage(newImage);
    newDish.setCategory(categoryDish);
    categoryDish.getDishList().add(newDish);

    Dish createdDish = dishRepository.save(newDish);
    categoryRepository.save(categoryDish);

    return dishMapper.toDto(createdDish);    
  }

  @Override
  public List<DishDto> getAllDishes(){
    List<Dish> listDishs = dishRepository.findAll();
    return listDishs.stream()
    .map((Dish) -> dishMapper.toDto(Dish))
    .collect(Collectors.toList());
  }

  @Override
  public DishDto getDishById(int id){
    Dish existingDish = dishRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dish not found"));
    return dishMapper.toDto(existingDish);
  }

  @Override
  public List<DishDto> getDishByCategory (String categoryName){
    List<Dish> listDishs = dishRepository.findByCategory(categoryName);
    return listDishs.stream()
    .map((Dish) -> dishMapper.toDto(Dish))
    .collect(Collectors.toList());
  };

  @Override
  public DishDto updateDish(DishRequestDto request, MultipartFile imageFile, int id) throws IOException {
      Dish existingDish = dishRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dish not found"));
      
      Image newImage = imageService.uploadImage(imageFile);

      Category newCategory = categoryRepository.findByName(request.getCategory())
      .orElseThrow(() -> new EntityNotFoundException("Category not found"));

      Category oldCategory = existingDish.getCategory();

      if(!oldCategory.equals(newCategory)){
        oldCategory.getDishList().remove(id);
        newCategory.getDishList().add(existingDish);
        categoryRepository.save(oldCategory);
        categoryRepository.save(newCategory);
      }

      existingDish.setImage(newImage);
      dishMapper.updateEntityFromRequest(request, existingDish);      
      
      
      Dish updatedDish = dishRepository.save(existingDish);
      return dishMapper.toDto(updatedDish);
  }

  @Override
  public void deleteDish(int id){
    Dish dish = dishRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dish not found"));

    Category category = dish.getCategory();
    category.getDishList().remove(dish);
    categoryRepository.save(category);

    dishRepository.delete(dish);
    
  }
}
