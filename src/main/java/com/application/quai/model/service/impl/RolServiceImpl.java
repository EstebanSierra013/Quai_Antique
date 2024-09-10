package com.application.quai.model.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.entity.Rol;
import com.application.quai.model.repository.IRolRepository;
import com.application.quai.model.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{

    @Autowired
    private IRolRepository rolRepository;

    
    @Override
    public Rol getById(int id){
        Optional<Rol>  optionalRol = rolRepository.findById(id);
        if (optionalRol.isEmpty()){
            System.err.println("ERROR");
        }
        return optionalRol.get();
    }  
}
