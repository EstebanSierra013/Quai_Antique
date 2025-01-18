package com.application.quai.model.dto;

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
public class RestaurantDto {

  @NotNull
  private String name;

  @NotNull
  private String description;

  @NotNull
  private String amOpeningTime;

  @NotNull
  private String pmOpeningTime;

  @Positive
  private int maxGuests;  
}
