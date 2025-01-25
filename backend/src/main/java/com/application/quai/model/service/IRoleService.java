package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.RoleDto;
import com.application.quai.model.dto.request.RoleRequestDto;


public interface IRoleService {
  RoleDto createRole(RoleRequestDto Rol);
  RoleDto getRoleById( int id );
  List<RoleDto> getAllRoles();
  RoleDto updateRole(RoleRequestDto request, int id);
  void deleteRole( int id );
}
