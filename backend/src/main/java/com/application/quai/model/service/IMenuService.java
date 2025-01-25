package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.MenuDto;
import com.application.quai.model.dto.request.MenuRequestDto;


public interface IMenuService {
  MenuDto createMenu(MenuRequestDto menu);
  List<MenuDto> getAllMenus();
  MenuDto getMenuById( int id );
  MenuDto updateMenu(MenuRequestDto request, int id);
  void deleteMenu( int id );
}
