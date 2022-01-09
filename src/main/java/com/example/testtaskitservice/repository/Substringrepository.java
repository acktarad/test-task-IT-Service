package com.example.testtaskitservice.repository;

import com.example.testtaskitservice.model.ModelSubString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Substringrepository extends JpaRepository<ModelSubString, Integer> {
}
