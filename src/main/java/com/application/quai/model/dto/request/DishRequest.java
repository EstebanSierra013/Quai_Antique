package com.application.quai.model.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishRequest {
  
  private String title;
  private String description;
  private BigDecimal prix;
  private String category;
}
