package com.application.quai.model.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.RoleDto;
import com.application.quai.model.dto.request.RoleRequestDto;
import com.application.quai.model.entity.Role;
import com.application.quai.model.mapper.RoleMapper;
import com.application.quai.model.repository.IRoleRepository;
import com.application.quai.model.service.IRoleService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;
 
    @Override
    public RoleDto createRole(RoleRequestDto request){
        Role newRole = roleMapper.toEntity(request);
        Role createdRole = roleRepository.save(newRole);
        return roleMapper.toDto(createdRole); 
    }

    @Override
    public RoleDto getRoleById(int id){
        Role findRole = roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role not found"));
        return roleMapper.toDto(findRole);
    }  

    @Override
    public List<RoleDto> getAllRoles(){
        List<Role> listRoles = roleRepository.findAll();
        return listRoles.stream()
        .map((Role) -> roleMapper.toDto(Role))
        .collect(Collectors.toList());
    }


    @Override
    public RoleDto updateRole(RoleRequestDto request, int id) {
        Role existingRole = roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role not found"));
        roleMapper.updateEntityFromRequest(request, existingRole);
        Role updatedRole = roleRepository.save(existingRole);
        return roleMapper.toDto(updatedRole);
    }
    
    @Override
    public void deleteRole(int id){
        Role role = roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role not found"));
        roleRepository.delete(role);
    }
}
