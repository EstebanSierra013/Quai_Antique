package com.application.quai.model.dto;

import java.math.BigDecimal;

import com.application.quai.model.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
  
  private String title;
  private String description;
  private BigDecimal prix;
  private Category category;
}
