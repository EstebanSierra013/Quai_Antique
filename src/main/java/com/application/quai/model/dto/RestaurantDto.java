package com.application.quai.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

  private int idRestaurant;
  private String name;
  private String description;
  private String amOpeningTime;
  private String pmOpeningTime;
  private int MaxGuests;
  
}
