package com.application.quai.model.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.MenuDto;
import com.application.quai.model.dto.request.MenuRequestDto;
import com.application.quai.model.entity.Menu;
import com.application.quai.model.mapper.MenuMapper;
import com.application.quai.model.repository.IMenuRepository;
import com.application.quai.model.service.IMenuService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MenuServiceImpl implements IMenuService {

  @Autowired
  private IMenuRepository menuRepository;

  @Autowired
  private MenuMapper menuMapper;

  @Override
  public MenuDto createMenu(MenuRequestDto request){
    Menu newMenu = menuMapper.toEntity(request);
    Menu createdMenu = menuRepository.save(newMenu);
    return menuMapper.toDto(createdMenu);    
  }

  @Override
  public List<MenuDto> getAllMenus(){
    List<Menu> listMenu = menuRepository.findAll();
    return listMenu.stream()
    .map((Menu) -> menuMapper.toDto(Menu))
    .collect(Collectors.toList());
  }

  @Override
  public MenuDto getMenuById(int id){
    Menu findMenu = menuRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Menu not found"));
    return menuMapper.toDto(findMenu);
  }

  @Override
  public MenuDto updateMenu(MenuRequestDto request, int id) {
      Menu existingMenu = menuRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Menu not found"));
      menuMapper.updateEntityFromRequest(request, existingMenu);
      Menu updatedMenu = menuRepository.save(existingMenu);
      return menuMapper.toDto(updatedMenu);
  }

  @Override
  public void deleteMenu(int id){
    Menu menu = menuRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Menu not found"));
    menuRepository.delete(menu);
  }
}
