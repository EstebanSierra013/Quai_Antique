package com.application.quai.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.application.quai.model.entity.Image;

public interface IImageService {
  Image uploadImage( MultipartFile imageFile ) throws IOException;
  List<Image> getAllImages();
  Image getImageById( String name );
  void deleteImage( String name );
}
