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

import com.application.quai.model.entity.Role;
import com.application.quai.model.service.IRoleService;

@RestController
@RequestMapping("/rol")
public class RoleController {
  
  @Autowired
  private IRoleService roleService;

  @PostMapping("/")
  public ResponseEntity<?> create(@RequestBody Role request) {
    return ResponseEntity.ok(roleService.create(request));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable int id){
    return ResponseEntity.ok(roleService.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody Role Role, @PathVariable int id){
    return ResponseEntity.ok(roleService.update(Role, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable int id){
    roleService.deleteById(id);
    return ResponseEntity.ok("Deleted Role");
  }
  
}
