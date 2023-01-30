package com.example.refugio.repository;

import com.example.refugio.model.AdoptedAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptedAnimalRepository extends JpaRepository <AdoptedAnimal,Integer> {

}
