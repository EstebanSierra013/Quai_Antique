package com.application.quai.model.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDto {

  @Positive(message = "number of guests must be positive.")
  @Min(1)
  private int guestNumbers;
  
  @NotNull(message = "Reservation date is required")
  private LocalDate date;

  @NotNull(message = "Reservation time is required")
  private LocalTime hour;
  
  @Size(max = 200, message = "Allergies cannot exceed 200 characters")
  private String allergy;
  
}
