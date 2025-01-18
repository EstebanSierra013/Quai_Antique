package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.UserDto;
import com.application.quai.model.dto.request.UserRequest;



public interface IUserService {
  UserDto create(UserRequest user);
  List<UserDto> findAll();
  UserDto getByEmail( String id );
  void deleteById( String id );
}
