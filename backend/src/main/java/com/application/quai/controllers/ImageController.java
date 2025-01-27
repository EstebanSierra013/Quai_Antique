package com.application.quai.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.quai.model.service.IImageService;

@RestController
@RequestMapping("/images")
@CrossOrigin("http://localhost:4200/")
public class ImageController {
  
  @Autowired
  private IImageService imageService;

  @PostMapping("/")
  public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) {
    try {
      return ResponseEntity.ok(imageService.uploadImage(file));
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen: " + e.getMessage());
    }
  }

  @GetMapping("/{name}")
  public ResponseEntity<?> getImageById(@PathVariable String name){
    return ResponseEntity.ok(imageService.getImageById(name));
  }

  @GetMapping("/")
  public ResponseEntity<?> getAllImages(){
    return ResponseEntity.ok(imageService.getAllImages());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteImage(@PathVariable String name){
    imageService.deleteImage(name);
    return ResponseEntity.ok("Deleted Image");
  }
}
