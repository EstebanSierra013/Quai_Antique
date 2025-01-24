package com.application.quai.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservations")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reservation{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idReservation;

  @Column
  private int guests;


  @Column(nullable=false)
  private LocalDate date;

  @Column(nullable=false)
  private LocalTime hour;

  @Column
  private String allergy;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="user", nullable=false)
  private User user;

}
