package com.application.quai.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
  
  @NotNull
  private int idMenu;
  private String title;
  private String description;
  private BigDecimal prix;
}
