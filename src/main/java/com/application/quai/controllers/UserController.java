package com.application.quai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.quai.model.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private IUserService userService;

  @GetMapping("/{email}")
  public ResponseEntity<?> getById(@PathVariable String email){
    System.out.println(email);
    return ResponseEntity.ok(userService.getByEmail(email));
  }
}
