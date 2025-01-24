package com.application.quai.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

  @NotBlank(message = "Email is mandatory")
  @Email(message = "Email should be valid")
  private String email;
  
  @NotBlank(message = "First name is mandatory")
  @Size(max = 50, message = "First name must not exceed 50 characters")
  private String firstname;

  @NotBlank(message = "Last name is mandatory")
  @Size(max = 50, message = "Last name must not exceed 50 characters")
  private String lastname;  

  @NotBlank(message = "Password is mandatory")
  @Size(min = 8, message = "Password must be at least 8 characters long")
  private String password;
  
  @Positive(message="number of guests must be positive.")
  @Min(1)
  private int guests;
  
  @Size(max = 200, message = "Allergies cannot exceed 200 characters")
  private String allergy;
  
}
