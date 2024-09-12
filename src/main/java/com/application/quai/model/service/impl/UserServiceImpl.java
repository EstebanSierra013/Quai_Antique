package com.application.quai.model.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.UserDto;
import com.application.quai.model.dto.request.UserRequest;
import com.application.quai.model.entity.Rol;
import com.application.quai.model.entity.User;
import com.application.quai.model.mapper.UserDtoMapper;
import com.application.quai.model.mapper.UserRequestMapper;
import com.application.quai.model.repository.IRolRepository;
import com.application.quai.model.repository.IUserRepository;
import com.application.quai.model.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserRequestMapper userRequestMapper;

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public UserDto create(UserRequest user){
        User newUser = userRequestMapper.toDomain(user);

        String rolDefault = "Client";
        Rol rolClient = rolRepository.findByName(rolDefault);
        if(rolClient != null){
            newUser.setRol(rolRepository.findByName(rolDefault));
            rolClient.getUserList().addAll(List.of(newUser));
        }    
        
        User createdUser = userRepository.save(newUser);
        return userDtoMapper.toDto(createdUser);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> listUsers = userRepository.findAll();
        System.out.println(listUsers);
        return listUsers.stream()
        .map((user) -> userDtoMapper.toDto(user))
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
        System.out.println(userDtoMapper.toDto(findRestaurant));
        return userDtoMapper.toDto(findRestaurant);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
