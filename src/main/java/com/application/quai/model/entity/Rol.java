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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rol")
public class Rol{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idRol;

  @NotNull
  @Column(nullable=false)
  private String name;

  @OneToMany(mappedBy="rol", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
  @JsonIgnore
  private List<User> userList;

}
