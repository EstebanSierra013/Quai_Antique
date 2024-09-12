package com.application.quai.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
  
  private String email;
  private String firstname;
  private String lastname;
  private String password;
  private int guestNumbers;
  private String allergy;
}
