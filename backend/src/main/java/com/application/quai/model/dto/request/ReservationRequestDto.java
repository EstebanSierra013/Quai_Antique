package com.application.quai.model.dto.request;

import java.time.LocalDateTime;

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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDto {

  @NotNull
  @Min(value = 1)
  @Max(value = 100)
  private int guests;
  
  @NotNull
  private LocalDateTime date;

  @Size(max = 200)
  private String allergy;

  @NotBlank
  @Email
  private String userEmail;
  
}
