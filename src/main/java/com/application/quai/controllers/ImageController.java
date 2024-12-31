package com.application.quai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.quai.model.service.IImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
  
  @Autowired
  private IImageService imageService;

  @PostMapping("/")
  public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) {
    String uploadImage = imageService.uploadImage(file);
    return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable int id){
    return ResponseEntity.ok(imageService.getById(id));
  }

  @GetMapping("/list")
  public ResponseEntity<?> findAll(){
    return ResponseEntity.ok(imageService.findAll());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable int id){
    imageService.deleteById(id);
    return ResponseEntity.ok("Deleted Image");
  }
}
