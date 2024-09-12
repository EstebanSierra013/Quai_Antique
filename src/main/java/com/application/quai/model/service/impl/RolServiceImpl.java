package com.application.quai.model.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.RolDto;
import com.application.quai.model.entity.Rol;
import com.application.quai.model.mapper.RolDtoMapper;
import com.application.quai.model.repository.IRolRepository;
import com.application.quai.model.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private RolDtoMapper rolDtoMapper;
    
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

}
