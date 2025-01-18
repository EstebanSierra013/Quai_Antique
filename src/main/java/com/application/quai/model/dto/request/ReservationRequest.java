package com.application.quai.model.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

  @Positive(message = "number of guests must be positive.")
  private int guestNumbers;
  
  @FutureOrPresent(message = "date must be valid.")
  private LocalDate date;

  @FutureOrPresent(message = "hour must be valid.")
  private LocalTime hour;

  private String allergy;
  
}
