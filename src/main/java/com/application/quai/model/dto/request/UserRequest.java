package com.application.quai.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
  
  @Email(message="email shouldnt be null.")
  private String email;

  @NotNull(message="firstname shouldnt be null.")
  private String firstname;

  @NotNull(message="lastname shouldnt be null.")
  private String lastname;

  @NotNull(message="email shouldnt be null.")
  private String password;
  
  @Positive(message="number of guests must be positive.")
  @Min(1)
  private int guestNumbers;
  
  private String allergy;
}
