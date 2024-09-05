package com.application.quai.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "rol")
public class Rol{

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int idRol;

 @Column(nullable=false)
 private String name;

 @OneToMany(mappedBy="rolId", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
 private List<User> userList;

}
