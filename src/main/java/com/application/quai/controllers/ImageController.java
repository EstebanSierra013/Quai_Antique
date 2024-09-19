package com.application.quai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("/{fileName}")
  public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
    byte[] imageData = imageService.downloadImage(fileName);
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.valueOf(IMAGE_JPEG_VALUE))
            .body(imageData);
  }
}
