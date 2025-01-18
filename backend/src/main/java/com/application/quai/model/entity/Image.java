package com.application.quai.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "image")
public class Image{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idImage;

  @NotNull
  @Column(nullable=false)
  private String name;

  @Column(nullable=false)
  private String type;

  @NotNull
  @Column(nullable=false)
  private String url;
}
