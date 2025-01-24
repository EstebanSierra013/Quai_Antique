package com.application.quai.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idRole;

  @NotNull
  @Column(nullable=false)
  private String name;

  @OneToMany(mappedBy="role", cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<User> userList;

}
