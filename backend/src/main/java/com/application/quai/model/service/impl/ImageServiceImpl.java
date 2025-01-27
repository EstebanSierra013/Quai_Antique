package com.application.quai.model.service.impl;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.quai.model.entity.Image;
import com.application.quai.model.repository.IImageRepository;
import com.application.quai.model.service.IImageService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ImageServiceImpl implements IImageService {

  @Autowired
  private IImageRepository imageRepository;

  private final Path uploadPath = Paths.get("./uploads");


  @Override
  public Image uploadImage(MultipartFile imageFile) throws IOException {
    if (!Files.exists(uploadPath)) {
      Files.createDirectories(uploadPath);
    }

    Files.copy(imageFile.getInputStream(), this.uploadPath.resolve(imageFile.getOriginalFilename()));   
    String fileName = imageFile.getOriginalFilename();
    Path filePath = uploadPath.resolve(fileName);

    Image newImage = new Image();
    newImage.setName(fileName);
    newImage.setUrl(filePath.toString());
    newImage.setType(imageFile.getContentType());

    return imageRepository.save(newImage);
  } 

  @Override
  public List<Image> getAllImages(){
    List<Image> listImages = imageRepository.findAll();
    return listImages.stream()
    .map((Image) -> Image)
    .collect(Collectors.toList());
  }

  @Override
  public Image getImageById(String name){
    Image existingImage = imageRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Image not found"));
    return existingImage;
  }

  @Override
  public void deleteImage(String name){
    Image image = imageRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Image not found"));
    
    Path imageFile = uploadPath.resolve(image.getUrl());
    
    try{
    Files.deleteIfExists(imageFile);
    } catch (IOException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }

    imageRepository.delete(image);
  }
}
