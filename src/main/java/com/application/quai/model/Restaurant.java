package com.application.quai.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "restaurant")
public class Restaurant{

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int idRestaurant;

 @Column(nullable=false)
 private String name;

 @Column(nullable=false)
 private String description;

 @Column(nullable=false)
 private LocalDate amOpeningTime;

 @Column(nullable=false)
 private LocalDate pmOpeningTime;

 @Column
 private int MaxGuests;

}
