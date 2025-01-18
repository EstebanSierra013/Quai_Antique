package com.application.quai.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.quai.model.entity.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {
  
}
