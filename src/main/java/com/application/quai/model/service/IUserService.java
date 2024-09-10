package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.entity.User;



public interface IUserService {
  User create(User user);
  List<User> findAll();
  User getByEmail( String id );
  void save(User user);
  void deleteById( String id );
}
