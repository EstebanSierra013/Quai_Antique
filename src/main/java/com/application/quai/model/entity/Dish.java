package com.application.quai.model.entity;

import java.text.DecimalFormat;

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

 @Column(nullable=false)
 private String title;

 @Column(nullable=false)
 private String description;

 @Column(nullable=false)
 private DecimalFormat prix;

 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name="imageId", nullable=false)
 private Image imageId;

 @ManyToOne(cascade=CascadeType.ALL)
 @JoinColumn(name="categoryId", nullable=false)
 private Category categoryId; 
}
