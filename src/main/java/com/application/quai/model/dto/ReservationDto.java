package com.application.quai.model.dto;

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
public class ReservationDto {

  private int idReservation;

  @Positive
  private int guestNumbers;

  @FutureOrPresent
  private LocalDate date;

  @FutureOrPresent
  private LocalTime hour;
  
  private String allergy;
  
}
