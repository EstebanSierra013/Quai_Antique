package com.application.quai.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {

  private String name;
  private String description;
  private String amOpeningTime;
  private String pmOpeningTime;
  private int maxGuests;
  
}
