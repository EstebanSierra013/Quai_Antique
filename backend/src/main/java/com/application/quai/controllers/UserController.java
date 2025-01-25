package com.application.quai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.quai.model.dto.request.UserRequestDto;
import com.application.quai.model.service.IUserService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/users")
public class UserController {
  
  @Autowired
  private IUserService userService;

  @PostMapping("/register")
  public ResponseEntity<?> createUser(@RequestBody UserRequestDto request) {
    System.out.println(request);
    return ResponseEntity.ok(userService.createUser(request));
  }

  @GetMapping("/{email}")
  public ResponseEntity<?> getUserById(@PathVariable String email){
    return ResponseEntity.ok(userService.getUserByEmail(email));
  }

  @GetMapping("/")
  public ResponseEntity<?> getAllUsers(){
    return ResponseEntity.ok(userService.getAllUsers());
  }
  
  @PutMapping("/{email}")
  public ResponseEntity<?> updateUser(@RequestBody UserRequestDto user, @PathVariable String email){
    return ResponseEntity.ok(userService.updateUser(user, email));
  }

  @DeleteMapping("/{email}")
  public ResponseEntity<?> deleteUser(@PathVariable String email){
    userService.deleteUser(email);
    return ResponseEntity.ok("Deleted User");
  }
}
