package com.application.quai.model.dto.request;

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
public class RestaurantRequest {

  @NotNull(message = "name shouldnt be null.")
  private String name;

  @NotNull(message = "description shouldnt be null.")
  private String description;

  @NotNull(message = "morning opening time shouldnt be null.")
  private String amOpeningTime;

  @NotNull(message = "afternoon opening time shouldnt be null.")
  private String pmOpeningTime;

  @Positive(message = "guests must be positive.")
  private int maxGuests;
  
}
