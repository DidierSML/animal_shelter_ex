package com.example.refugio.service;
import com.example.refugio.exceptions.AnimalNotFoundCustomException;
import com.example.refugio.model.AdoptedAnimal;
import com.example.refugio.repository.AdoptedAnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AdoptedAnimalService {


    private final AdoptedAnimalRepository adoptedAnimalRepository;

    public AdoptedAnimal save (AdoptedAnimal animal) { return adoptedAnimalRepository.save(animal);}
    public List<AdoptedAnimal>findAll(){return adoptedAnimalRepository.findAll();}
    public AdoptedAnimal findById (Integer id) {
        return adoptedAnimalRepository.findById(id).orElseThrow(() -> new AnimalNotFoundCustomException("Animal not found, please verify"));
    }

    public void deleteById (Integer id){ adoptedAnimalRepository.deleteById(id);}

    public AdoptedAnimal update(AdoptedAnimal animal){return adoptedAnimalRepository.save(animal);}






}
