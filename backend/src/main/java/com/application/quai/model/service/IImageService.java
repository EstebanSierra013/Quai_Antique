package com.application.quai.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.application.quai.model.entity.Image;

public interface IImageService {
  String uploadImage( MultipartFile imageFile );
  List<Image> findAll();
  Image getById( int id );
  void deleteById( int id );
}
