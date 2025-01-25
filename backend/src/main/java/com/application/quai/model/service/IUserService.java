package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.UserDto;
import com.application.quai.model.dto.request.UserRequestDto;



public interface IUserService {
  UserDto createUser (UserRequestDto user);
  List<UserDto> getAllUsers();
  UserDto getUserByEmail( String id );
  UserDto updateUser( UserRequestDto user, String id);
  void deleteUser( String id );
}
