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

import com.application.quai.model.dto.request.RoleRequestDto;
import com.application.quai.model.service.IRoleService;

@RestController
@RequestMapping("/roles")
@CrossOrigin("http://localhost:4200/")
public class RoleController {
  
  @Autowired
  private IRoleService roleService;

  @PostMapping("/")
  public ResponseEntity<?> createRole(@RequestBody RoleRequestDto request) {
    return ResponseEntity.ok(roleService.createRole(request));
  }
  
  @GetMapping("/")
  public ResponseEntity<?> getAllRoles(){
    return ResponseEntity.ok(roleService.getAllRoles());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getRoleById(@PathVariable int id){
    return ResponseEntity.ok(roleService.getRoleById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateRole(@RequestBody RoleRequestDto Role, @PathVariable int id){
    return ResponseEntity.ok(roleService.updateRole(Role, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteRole(@PathVariable int id){
    roleService.deleteRole(id);
    return ResponseEntity.ok("Deleted Role");
  }
  
}
