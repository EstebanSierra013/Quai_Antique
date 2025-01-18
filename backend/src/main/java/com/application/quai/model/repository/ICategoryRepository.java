package com.application.quai.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.quai.model.entity.Category;


@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
  Category findByName(String name);
}
