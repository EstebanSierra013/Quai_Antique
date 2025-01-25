package com.application.quai.model.dto;

import java.math.BigDecimal;

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
  private CategoryDto category;
  private String imageUrl;
}
