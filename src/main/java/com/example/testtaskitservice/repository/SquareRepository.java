package com.example.testtaskitservice.repository;

import com.example.testtaskitservice.model.ModelSquare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquareRepository extends JpaRepository<ModelSquare, Integer> {
}
