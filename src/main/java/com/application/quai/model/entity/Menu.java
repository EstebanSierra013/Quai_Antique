package com.application.quai.model.entity;

import java.math.BigDecimal;

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
@Table(name = "menu")
public class Menu{

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int idMenu;

 @Column(nullable=false)
 private String title;

 @Column(nullable=false)
 private String description;

 @Column(nullable=false)
 private BigDecimal prix;
 
}
