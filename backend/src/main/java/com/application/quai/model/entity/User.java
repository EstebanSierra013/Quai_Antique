package com.application.quai.model.entity;

import java.util.ArrayList;
import java.util.List;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User{

  @Id
  private String email;

  @Column(nullable=false)
  private String firstname;

  @Column(nullable=false)
  private String lastname;

  @Column(nullable=false)
  private String password;

  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="role_id", nullable=false)
  private Role role;

  private int guests;
  private String allergy;

  @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
  private List<Reservation> reservationList = new ArrayList<> ();
}
