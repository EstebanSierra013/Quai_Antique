package com.application.quai.model.service;

import com.application.quai.model.entity.Role;


public interface IRoleService {
  Role create(Role Rol);
  Role getById( int id );
  Role update(Role request, int id);
  void deleteById( int id );
}
