package com.application.quai.model.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuRequestDto {
  
  @NotBlank
  @Size(max = 50)
  private String title;

  @NotBlank
  @Size(max = 250)
  private String description;

  @NotNull
  @DecimalMin(value = "0.01")
  @Digits(integer = 3, fraction = 2)
  private BigDecimal prix;
}
