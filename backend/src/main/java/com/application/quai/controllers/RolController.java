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

import com.application.quai.model.dto.request.RolRequest;
import com.application.quai.model.service.IRolService;

@RestController
@RequestMapping("/rol")
public class RolController {
  
  @Autowired
  private IRolService rolService;

  @PostMapping("/")
  public ResponseEntity<?> create(@RequestBody RolRequest request) {
    return ResponseEntity.ok(rolService.create(request));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable int id){
    return ResponseEntity.ok(rolService.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody RolRequest Rol, @PathVariable int id){
    return ResponseEntity.ok(rolService.update(Rol, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable int id){
    rolService.deleteById(id);
    return ResponseEntity.ok("Deleted Rol");
  }
  
}
