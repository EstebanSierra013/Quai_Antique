package com.application.quai.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "reservation")
public class Reservation{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idReservation;

  @Column
  private int guestNumbers;

  @Column(nullable=false)
  private LocalDate date;

  @Column(nullable=false)
  private LocalTime hour;

  @Column
  private String allergy;

  @ManyToOne(cascade=CascadeType.MERGE)
  @JoinColumn(name="user")
  private User user;

}
