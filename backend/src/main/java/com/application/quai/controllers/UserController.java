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
import org.springframework.web.bind.annotation.RestController;

import com.application.quai.model.dto.request.UserRequestDto;
import com.application.quai.model.service.IUserService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class UserController {
  
  @Autowired
  private IUserService userService;

  @GetMapping("/user/{email}")
  public ResponseEntity<?> getById(@PathVariable String email){
    return ResponseEntity.ok(userService.getByEmail(email));
  }

  @GetMapping("/users")
  public ResponseEntity<?> findAll(){
    return ResponseEntity.ok(userService.findAll());
  }
  
  @PostMapping("/register")
  public ResponseEntity<?> create(@RequestBody UserRequestDto request) {
    System.out.println(request);
    return ResponseEntity.ok(userService.create(request));
  }

  @PutMapping("/user/{email}")
  public ResponseEntity<?> update(@RequestBody UserRequestDto user, @PathVariable String email){
    return ResponseEntity.ok(userService.update(user, email));
  }

  @DeleteMapping("/user/{email}")
  public ResponseEntity<?> deleteById(@PathVariable String email){
    userService.deleteById(email);
    return ResponseEntity.ok("Deleted User");
  }
}
