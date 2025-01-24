package com.application.quai.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private String email;
  private String firstname;
  private String lastname;
  private String roleName;
  private int guests;
  private String allergy;
  public List<ReservationDto> reservationList;
}
