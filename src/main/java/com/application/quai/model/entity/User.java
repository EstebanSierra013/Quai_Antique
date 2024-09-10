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
  private String email;

  @Column(nullable=false)
  private String firstname;

  @Column(nullable=false)
  private String lastname;

  @Column(nullable=false)
  private String password;

  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="rolId", nullable=false)
  private Rol rolId;

  @Column
  private Integer guestNumbers;

  @Column
  private String allergy;

  @OneToMany(mappedBy="userId", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
  @JsonIgnore
  private List<Reservation> reservationList;
}
