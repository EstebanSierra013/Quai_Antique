package com.application.quai.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.quai.model.entity.Menu;


@Repository
public interface IMenuRepository extends JpaRepository<Menu, Integer> {
}
