package com.application.quai.model.dto;

import com.application.quai.model.entity.Rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  
  private String email;
  private String firstname;
  private String lastname;
  private String password;
  private Rol rol;
  private int guestNumbers;
  private String allergy;
}
