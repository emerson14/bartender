package com.example.bartender.repository;

import com.example.bartender.model.ArrayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrayRepository extends JpaRepository<ArrayEntity, Integer> {
}