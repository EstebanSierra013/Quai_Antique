package com.application.quai.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.entity.User;
import com.application.quai.model.repository.IUserRepository;
import com.application.quai.model.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private RolServiceImpl rolService;

    @Override
    public User create(User user){
        user.setRolId(rolService.getById(2));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByEmail(String email){
        Optional<User>  optionalUser = userRepository.findById(email);
        if (optionalUser.isEmpty()){
            System.err.println("ERROR");
        }
        return optionalUser.get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
  
}
