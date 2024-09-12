package com.application.quai.model.dto;

import java.util.List;

import com.application.quai.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RolDto {
  
  private String name;
  private List<User> userList;
}
