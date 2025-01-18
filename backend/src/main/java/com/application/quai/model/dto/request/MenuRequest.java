package com.application.quai.model.dto.request;

import java.math.BigDecimal;

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
public class MenuRequest {
  
  @NotNull(message = "title shouldnt be null.")
  private String title;

  @NotNull(message = "description shouldnt be null.")
  private String description;

  @Positive(message = "prix must be positive.")
  private BigDecimal prix;
}
