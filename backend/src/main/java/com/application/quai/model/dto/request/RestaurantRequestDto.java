package com.application.quai.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDto {

  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotBlank
  private String amOpeningTime;

  @NotBlank
  private String pmOpeningTime;

  @NotNull
  @Min(value = 1)
  private int maxGuests;
  
}
