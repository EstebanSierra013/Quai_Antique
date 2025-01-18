package com.application.quai.model.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.RolDto;
import com.application.quai.model.dto.request.RolRequest;
import com.application.quai.model.entity.Rol;
import com.application.quai.model.mapper.RolDtoMapper;
import com.application.quai.model.mapper.RolRequestMapper;
import com.application.quai.model.repository.IRolRepository;
import com.application.quai.model.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private RolDtoMapper rolDtoMapper;
    
    @Autowired
    private RolRequestMapper rolRequestMapper;
    
    @Override
    public RolDto create(RolRequest request){
      Rol newRol = rolRequestMapper.toDomain(request);
      Rol createdRol = rolRepository.save(newRol);
      return rolDtoMapper.toDto(createdRol);    
    }

    public Rol getByRol(int id){
        Optional<Rol>  optionalRol = rolRepository.findById(id);
        if (optionalRol.isEmpty()){
            System.err.println("ERROR");
        }
        return optionalRol.get();
    }

    @Override
    public RolDto getById(int id){
        Rol findRol = getByRol(id);
        return rolDtoMapper.toDto(findRol);
    }  

    @Override
    public RolDto update(RolRequest request, int id) {
        Rol rolToUpdate = this.getByRol(id);
        setValuesToUpdate(request,rolToUpdate);
        Rol updatedRol = rolRepository.save(rolToUpdate);
        return rolDtoMapper.toDto(updatedRol);
    }

    private void setValuesToUpdate(RolRequest request, Rol currentRol){
        currentRol.setName(request.getName());
    }

    @Override
    public void deleteById(int id){
        rolRepository.deleteById(id);
    }
}
