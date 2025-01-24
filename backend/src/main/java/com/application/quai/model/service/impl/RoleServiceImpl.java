package com.application.quai.model.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.entity.Role;
import com.application.quai.model.repository.IRoleRepository;
import com.application.quai.model.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleRepository roleRepository;
 
    @Override
    public Role create(Role request){
      Role createdRole = roleRepository.save(request);
      return createdRole; 
    }

    public Role getByRole(int id){
        Optional<Role>  optionalRole = roleRepository.findById(id);
        if (optionalRole.isEmpty()){
            System.err.println("ERROR");
        }
        return optionalRole.get();
    }

    @Override
    public Role getById(int id){
        Role findRole = getByRole(id);
        return findRole;
    }  

    @Override
    public Role update(Role request, int id) {
        Role roleToUpdate = this.getByRole(id);
        Role updatedRole = roleRepository.save(roleToUpdate);
        return updatedRole;
    }
    
    @Override
    public void deleteById(int id){
        roleRepository.deleteById(id);
    }
}
