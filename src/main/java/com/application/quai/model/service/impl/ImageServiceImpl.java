package com.application.quai.model.service.impl;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.quai.model.entity.Image;
import com.application.quai.model.repository.IImageRepository;
import com.application.quai.model.service.IImageService;
import com.application.quai.model.util.ImageUtils;

@Service
public class ImageServiceImpl implements IImageService {

  @Autowired
  private IImageRepository imageRepository;

  @Override
  public String uploadImage(MultipartFile imageFile){
    try{
      Image newImage = Image.builder()
          .name(imageFile.getOriginalFilename())
          .type(imageFile.getContentType())
          .imageData(ImageUtils.compressImage(imageFile.getBytes()))
          .build();
      imageRepository.save(newImage);
    }catch(IOException exception){
      System.err.println(exception);
    }
    return "File uploaded successfully : " + imageFile.getOriginalFilename();
  } 

  @Override
  public byte[] downloadImage(String imageName) {
    Image loadImage = getByImage(imageName);
    try {
      return ImageUtils.decompressImage(loadImage.getImageData());
    } catch (DataFormatException | IOException exception) {
      System.err.println(exception);
    }
    return null;
  }

  public Image getByImage(String name){
    Optional<Image> optionalImage = imageRepository.findByName(name);
    if (optionalImage.isEmpty()){
        System.err.println("ERROR");
    }
    return optionalImage.get();
  }
}
