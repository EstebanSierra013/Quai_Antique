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

import com.application.quai.model.dto.request.MenuRequestDto;  
import com.application.quai.model.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {
  
  @Autowired
  private IMenuService menuService;

  @PostMapping("/")
  public ResponseEntity<?> createMenu(@RequestBody MenuRequestDto request) {
    return ResponseEntity.ok(menuService.createMenu(request));
  }

  @GetMapping("/")
  public ResponseEntity<?> getAllMenus(){
    return ResponseEntity.ok(menuService.getAllMenus());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getMenuById(@PathVariable int id){
    return ResponseEntity.ok(menuService.getMenuById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateMenu(@RequestBody MenuRequestDto Menu, @PathVariable int id){
    return ResponseEntity.ok(menuService.updateMenu(Menu, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteMenu(@PathVariable int id){
    menuService.deleteMenu(id);
    return ResponseEntity.ok("Deleted Menu");
  }
}
