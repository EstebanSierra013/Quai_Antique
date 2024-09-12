package com.application.quai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.quai.model.service.IRolService;

@RestController
@RequestMapping("/rol")
public class RolController {
  
  @Autowired
  private IRolService rolService;

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable int id){
    return ResponseEntity.ok(rolService.getById(id));
  }
  
}
