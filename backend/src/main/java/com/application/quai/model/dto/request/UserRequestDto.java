package com.application.quai.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

  @NotBlank
  @Email
  private String email;
  
  @NotBlank
  @Size(max = 50)
  private String firstname;

  @NotBlank
  @Size(max = 50)
  private String lastname;  

  @NotBlank
  @Size(min = 8)
  private String password;
  
  @NotNull
  @Min(value = 1)
  @Max(value = 100)
  private int guests;
  
  @Size(max = 200)
  private String allergy;
  
}
