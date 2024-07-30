package com.example.bartender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bartender.entity.ArrayEntity;

public interface ArrayRepository extends JpaRepository<ArrayEntity, Integer> {
}