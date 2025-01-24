package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.UserDto;
import com.application.quai.model.dto.request.UserRequestDto;



public interface IUserService {
  UserDto create (UserRequestDto user);
  List<UserDto> findAll();
  UserDto getByEmail( String id );
  UserDto update( UserRequestDto user, String id);
  void deleteById( String id );
}
