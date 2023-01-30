package com.example.refugio.service;
import com.example.refugio.model.AdoptedAnimal;
import com.example.refugio.repository.AdoptedAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class AdoptedAnimalService {

    @Autowired
    private AdoptedAnimalRepository adoptedAnimalRepository;

    public AdoptedAnimal save (AdoptedAnimal animal) { return adoptedAnimalRepository.save(animal);}
    public List<AdoptedAnimal>findAll(){return adoptedAnimalRepository.findAll();}
    public Optional<AdoptedAnimal> findById (Integer id) { return adoptedAnimalRepository.findById(id);}

    public void deleteById (Integer id){ adoptedAnimalRepository.deleteById(id);}


    public AdoptedAnimal update(AdoptedAnimal animal){return adoptedAnimalRepository.save(animal);}






}
