package com.application.quai.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
@Table(name = "user")
public class User{

  @Id
  @Email
  @Size(max = 50)
  private String email;

  @NotNull
  @Column(nullable=false)
  private String firstname;

  @NotNull
  @Column(nullable=false)
  private String lastname;

  @NotNull
  @Column(nullable=false)
  private String password;

  @NotNull
  @ManyToOne(cascade=CascadeType.MERGE)
  @JoinColumn(name="rol", nullable=false)
  private Rol rol;

  @Positive
  @Column
  private int guestNumbers;

  @Column
  private String allergy;

  @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
  @JsonIgnore
  private List<Reservation> reservationList;

}
