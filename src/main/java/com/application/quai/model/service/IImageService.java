package com.application.quai.model.service;

import org.springframework.web.multipart.MultipartFile;


public interface IImageService {
  String uploadImage(MultipartFile imageFile);
  byte[] downloadImage(String imageName);
}
