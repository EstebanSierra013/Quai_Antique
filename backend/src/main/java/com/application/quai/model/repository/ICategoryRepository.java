package com.application.quai.model.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.quai.model.entity.Category;


@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
  Optional<Category> findByName(String name);
}
