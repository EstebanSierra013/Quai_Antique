package com.application.quai.model.dto;

import com.application.quai.model.entity.Rol;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  
  @Email
  private String email;

  @NotNull
  private String firstname;

  @NotNull
  private String lastname;

  @NotNull
  private String password;

  private Rol rol;

  @Positive
  private int guestNumbers;

  private String allergy;
}
