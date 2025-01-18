package com.application.quai.model.dto;

import java.math.BigDecimal;

import com.application.quai.model.entity.Category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {

  @NotNull
  private String title;

  @NotNull
  private String description;

  @Positive
  private BigDecimal prix;

  @NotNull
  private Category category;
}
