package com.application.quai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.quai.model.dto.request.MenuRequest;  
import com.application.quai.model.service.IMenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
  
  @Autowired
  private IMenuService menuService;

  @PostMapping("/")
  public ResponseEntity<?> create(@RequestBody MenuRequest request) {
    return ResponseEntity.ok(menuService.create(request));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable int id){
    return ResponseEntity.ok(menuService.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody MenuRequest Menu, @PathVariable int id){
    return ResponseEntity.ok(menuService.update(Menu, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable int id){
    menuService.deleteById(id);
    return ResponseEntity.ok("Deleted Menu");
  }
}
