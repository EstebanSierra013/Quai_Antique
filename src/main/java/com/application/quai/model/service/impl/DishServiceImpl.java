package com.application.quai.model.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.DishDto;
import com.application.quai.model.dto.request.DishRequest;
import com.application.quai.model.entity.Category;
import com.application.quai.model.entity.Dish;
import com.application.quai.model.mapper.DishDtoMapper;
import com.application.quai.model.mapper.DishRequestMapper;
import com.application.quai.model.repository.ICategoryRepository;
import com.application.quai.model.repository.IDishRepository;
import com.application.quai.model.service.IDishService;

@Service
public class DishServiceImpl implements IDishService {

  @Autowired
  private IDishRepository dishRepository;

  @Autowired
  private ICategoryRepository categoryRepository;

  @Autowired
  private DishDtoMapper dishDtoMapper;

  @Autowired
  private DishRequestMapper dishRequestMapper;

  @Override
  public DishDto create(DishRequest request){
    Dish newDish = dishRequestMapper.toDomain(request);

    Category categoryDish = categoryRepository.findByName(request.getCategory());
    if(categoryDish != null){
        newDish.setCategory(categoryRepository.findByName(request.getCategory()));
        categoryDish.getDishList().addAll(List.of(newDish));
    }    

    Dish createdDish = dishRepository.save(newDish);
    return dishDtoMapper.toDto(createdDish);    
  }

  public Dish getByDish(int id){
    Optional<Dish> optionalDish = dishRepository.findById(id);
    if (optionalDish.isEmpty()){
        System.err.println("ERROR");
    }
    return optionalDish.get();
  }

  @Override
  public List<DishDto> findAll(){
    List<Dish> listDishs = dishRepository.findAll();
    return listDishs.stream()
    .map((Dish) -> dishDtoMapper.toDto(Dish))
    .collect(Collectors.toList());
  }

  @Override
  public DishDto getById(int id){
    Dish findDish = getByDish(id);
    return dishDtoMapper.toDto(findDish);
  }

  @Override
  public DishDto update(DishRequest request, int id) {
      Dish dishToUpdate = this.getByDish(id);
      setValuesToUpdate(request,dishToUpdate);
      Dish updatedDish = dishRepository.save(dishToUpdate);
      return dishDtoMapper.toDto(updatedDish);
  }

  private void setValuesToUpdate(DishRequest request, Dish currentDish){
      currentDish.setTitle(request.getTitle());
      currentDish.setDescription(request.getDescription());
      currentDish.setPrix(request.getPrix());
  }

  @Override
  public void deleteById(int id){
    dishRepository.deleteById(id);
  }
}
