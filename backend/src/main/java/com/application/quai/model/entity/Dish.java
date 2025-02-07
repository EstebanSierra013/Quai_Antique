package com.application.quai.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "dish")
public class Dish{

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int idDish;

 @NotNull
 @Column(nullable=false)
 private String title;

 @NotNull
 @Column(nullable=false)
 private String description;

 @Positive
 @Column(nullable=false)
 private BigDecimal prix;

 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name="imageId")
 private Image imageId;

 @ManyToOne(cascade=CascadeType.MERGE)
 @JoinColumn(name="category", nullable=false)
 private Category category; 
}
