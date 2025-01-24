package com.application.quai.model.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.UserDto;
import com.application.quai.model.dto.request.UserRequestDto;
import com.application.quai.model.entity.Role;
import com.application.quai.model.entity.User;
import com.application.quai.model.mapper.UserMapper;
import com.application.quai.model.repository.IRoleRepository;
import com.application.quai.model.repository.IUserRepository;
import com.application.quai.model.service.IUserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IRoleRepository roleRepository;

    @Transactional
    @Override
    public UserDto create(UserRequestDto user){
        User newUser = userMapper.toEntity(user);
        System.out.println(user);
        System.out.println(newUser);
        String rolDefault = "Client";
        
        Role roleClient = roleRepository.findByName(rolDefault);
        if(roleClient != null){
            newUser.setRole(roleRepository.findByName(rolDefault));
            roleClient.getUserList().addAll(List.of(newUser));
        }    
        
        User createdUser = userRepository.save(newUser);
        return userMapper.toDto(createdUser);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> listUsers = userRepository.findAll();
        return listUsers.stream()
        .map((user) -> userMapper.toDto(user))
        .collect(Collectors.toList());
    }

    public User getByUser(String email){
        Optional<User>  optionalUser = userRepository.findById(email);
        if (optionalUser.isEmpty()){
            System.err.println("ERROR");
        }
        return optionalUser.get();
    }

    @Override
    public UserDto getByEmail(String email){
        User findRestaurant = getByUser(email);
        return userMapper.toDto(findRestaurant);
    }

    @Override
    public UserDto update(UserRequestDto request, String id){
        User userToUpdate = this.getByUser(id);
        userMapper.updateEntityFromRequest(request, userToUpdate);
        User updatedUser = userRepository.save(userToUpdate);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
