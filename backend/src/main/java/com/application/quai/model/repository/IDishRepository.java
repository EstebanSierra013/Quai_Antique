package com.application.quai.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.quai.model.entity.Dish;


@Repository
public interface IDishRepository extends JpaRepository<Dish, Integer> {
  @Query(value = "SELECT d FROM Dish d LEFT JOIN Category c ON d.category.id = c.idCategory  WHERE d.category.name = :categoryName")
  List<Dish> findByCategory(@Param("categoryName") String categoryName); 
}
