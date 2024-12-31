package com.application.quai.model.service.impl;


import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.application.quai.model.entity.Image;
import com.application.quai.model.repository.IImageRepository;
import com.application.quai.model.service.IImageService;

@Service
public class ImageServiceImpl implements IImageService {

  @Autowired
  private IImageRepository imageRepository;

  private final Path uploadPath = Paths.get("./uploads");

  @Override
  public String uploadImage(MultipartFile imageFile){
    try{
      Files.copy(imageFile.getInputStream(), this.uploadPath.resolve(imageFile.getOriginalFilename()));      
      Image newImage = Image.builder()
          .name(imageFile.getOriginalFilename())
          .type(imageFile.getContentType())
          .url(this.uploadPath.resolve(imageFile.getOriginalFilename()).toString())
          .build();
      imageRepository.save(newImage);
    }catch(Exception e){
      if (e instanceof FileAlreadyExistsException) {
        throw new RuntimeException("A file of that name already exists.");
      }
      throw new RuntimeException(e.getMessage());
    }
    return "File uploaded successfully : " + imageFile.getOriginalFilename();
  } 

  public Image getByImage(String name){
    Optional<Image> optionalImage = imageRepository.findByName(name);
    if (optionalImage.isEmpty()){
        System.err.println("ERROR");
    }
    return optionalImage.get();
  }

  public Image getByImage(int id){
    Optional<Image> optionalImage = imageRepository.findById(id);
    if (optionalImage.isEmpty()){
        System.err.println("ERROR");
    }
    return optionalImage.get();
  }

  @Override
  public List<Image> findAll(){
    List<Image> listImages = imageRepository.findAll();
    return listImages.stream()
    .map((Image) -> Image)
    .collect(Collectors.toList());
  }

  @Override
  public Image getById(int id){
    Image findImage = getByImage(id);
    return findImage;
  }

  @Override
  public void deleteById(int id){
    try {
      Image image = getByImage(id);
      Path file = uploadPath.resolve(image.getName());
      imageRepository.deleteById(id);
      Files.deleteIfExists(file);
    } catch (IOException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }
}
