package com.application.quai.model.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
  private Long idRestaurant;

  @NotNull
  @Column(nullable=false)
  private String name;

  @NotNull
  @Column(nullable=false)
  private String description;

  @NotNull
  @Type(JsonType.class)
  @Column(nullable=false)
  private String amOpeningTime;

  @Type(JsonType.class)
  @Column(nullable=false)
  private String pmOpeningTime;

  @Positive
  @Column(nullable=false)
  private int maxGuests;
  
}
