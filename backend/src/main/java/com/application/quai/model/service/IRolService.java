package com.application.quai.model.service;

import com.application.quai.model.dto.RolDto;
import com.application.quai.model.dto.request.RolRequest;

public interface IRolService {
  RolDto create(RolRequest Rol);
  RolDto getById( int id );
  RolDto update(RolRequest request, int id);
  void deleteById( int id );
}
