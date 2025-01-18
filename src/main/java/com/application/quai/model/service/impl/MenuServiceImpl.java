package com.application.quai.model.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.MenuDto;
import com.application.quai.model.dto.request.MenuRequest;
import com.application.quai.model.entity.Menu;
import com.application.quai.model.mapper.MenuDtoMapper;
import com.application.quai.model.mapper.MenuRequestMapper;
import com.application.quai.model.repository.IMenuRepository;
import com.application.quai.model.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

  @Autowired
  private IMenuRepository menuRepository;

  @Autowired
  private MenuDtoMapper menuDtoMapper;

  @Autowired
  private MenuRequestMapper menuRequestMapper;

  @Override
  public MenuDto create(MenuRequest request){
    Menu newMenu = menuRequestMapper.toDomain(request);
    Menu createdMenu = menuRepository.save(newMenu);
    return menuDtoMapper.toDto(createdMenu);    
  }

  public Menu getByMenu(int id){
    Optional<Menu> optionalMenu = menuRepository.findById(id);
    if (optionalMenu.isEmpty()){
        System.err.println("ERROR");
    }
    return optionalMenu.get();
  }

  @Override
  public MenuDto getById(int id){
    Menu findMenu = getByMenu(id);
    return menuDtoMapper.toDto(findMenu);
  }

  @Override
  public MenuDto update(MenuRequest request, int id) {
      Menu menuToUpdate = this.getByMenu(id);
      setValuesToUpdate(request,menuToUpdate);
      Menu updatedMenu = menuRepository.save(menuToUpdate);
      return menuDtoMapper.toDto(updatedMenu);
  }

  private void setValuesToUpdate(MenuRequest request, Menu currentMenu){
      currentMenu.setTitle(request.getTitle());
      currentMenu.setDescription(request.getDescription());
      currentMenu.setPrix(request.getPrix());
  }

  @Override
  public void deleteById(int id){
    menuRepository.deleteById(id);
  }
}
