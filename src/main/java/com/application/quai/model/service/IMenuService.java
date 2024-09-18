package com.application.quai.model.service;

import com.application.quai.model.dto.MenuDto;
import com.application.quai.model.dto.request.MenuRequest;


public interface IMenuService {
  MenuDto create(MenuRequest menu);
  MenuDto getById( int id );
  MenuDto update(MenuRequest request, int id);
  void deleteById( int id );
}
