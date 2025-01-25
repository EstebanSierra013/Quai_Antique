package com.application.quai.model.service.impl;

import java.util.List;
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

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public UserDto createUser(UserRequestDto user){
        User newUser = userMapper.toEntity(user);
        String rolDefault = "Client";
        
        Role roleClient = roleRepository.findByName(rolDefault).orElseThrow(() -> new EntityNotFoundException("User not found"));

        newUser.setRole(roleClient);

        roleClient.getUserList().add(newUser);
        roleRepository.save(roleClient);

        User createdUser = userRepository.save(newUser);
        return userMapper.toDto(createdUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> listUsers = userRepository.findAll();
        return listUsers.stream()
        .map((user) -> userMapper.toDto(user))
        .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByEmail(String email){
        User existingUser = userRepository.findById(email).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toDto(existingUser);
    }

    @Override
    public UserDto updateUser(UserRequestDto request, String id){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));  
        userMapper.updateEntityFromRequest(request, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dish not found")); 
        userRepository.delete(user);
    }
}
