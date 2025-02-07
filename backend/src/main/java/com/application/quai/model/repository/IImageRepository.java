package com.application.quai.model.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.quai.model.entity.Image;

@Repository
public interface IImageRepository extends JpaRepository<Image, Integer> {
  Optional<Image> findByName(String name);
}
