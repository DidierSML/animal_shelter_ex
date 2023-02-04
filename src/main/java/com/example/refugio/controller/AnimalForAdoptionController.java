package com.example.refugio.controller;
import com.example.refugio.dto.AnimalForAdoptionDTO;
import com.example.refugio.mapper.IMapperForAdoption;
import com.example.refugio.model.AnimalForAdoption;
import com.example.refugio.service.AnimalForAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inAdoption")
public class AnimalForAdoptionController {

    @Autowired
    private IMapperForAdoption iMapperForAdoption;

    @Autowired
    private AnimalForAdoptionService animalService;


    @PostMapping("/saveAnimal")
    public ResponseEntity<AnimalForAdoption>saveAnimal(@RequestBody AnimalForAdoptionDTO forAdoptionDTO){
        return new ResponseEntity<>(animalService.save(iMapperForAdoption.dtoModel(forAdoptionDTO)), HttpStatus.CREATED);
    }

    @GetMapping("/getAllAnimals")
    public ResponseEntity<List<AnimalForAdoptionDTO>>findAllAnimals(){
        return new ResponseEntity(iMapperForAdoption.modelsToDtos(animalService.findAll()),HttpStatus.OK);
    }

    @GetMapping("/getAnimalId/{id}")
    public ResponseEntity<Optional<AnimalForAdoptionDTO>>findAnimalById(@PathVariable Integer id){
        return new ResponseEntity(iMapperForAdoption.modelToDto(animalService.findById(id).get()), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteAnimal/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable(value = "id") Integer id){
        AnimalForAdoptionDTO forAdoptionDTO = iMapperForAdoption.modelToDto(animalService.findById(id).get());
        animalService.deleteById(forAdoptionDTO.getIdAnimal());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateAnimal")
    public ResponseEntity <Object> updateAnimal (@RequestBody AnimalForAdoptionDTO forAdoptionDTO){
        return new ResponseEntity<>(animalService.update(iMapperForAdoption.dtoModel(forAdoptionDTO)),HttpStatus.OK);
    }


}
