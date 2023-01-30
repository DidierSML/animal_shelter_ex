package com.example.refugio.repository;

import com.example.refugio.model.AnimalForAdoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalForAdoptionRepository extends JpaRepository <AnimalForAdoption,Integer>{
}
