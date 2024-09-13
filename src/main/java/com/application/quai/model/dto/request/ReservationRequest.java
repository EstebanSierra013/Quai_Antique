package com.application.quai.model.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

  private int guestNumbers;
  private LocalDate date;
  private LocalTime hour;
  private String allergy;
  
}
