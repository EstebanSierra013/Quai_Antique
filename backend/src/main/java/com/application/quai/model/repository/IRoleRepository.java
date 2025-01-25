package com.application.quai.model.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.quai.model.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByName(String name);
}
