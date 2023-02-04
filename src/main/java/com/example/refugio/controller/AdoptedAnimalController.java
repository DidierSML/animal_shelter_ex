package com.example.refugio.controller;
import com.example.refugio.dto.AdoptedAnimalDTO;
import com.example.refugio.mapper.IMapperAdopted;
import com.example.refugio.model.AdoptedAnimal;
import com.example.refugio.service.AdoptedAnimalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/adopted")
public class AdoptedAnimalController {


    private final IMapperAdopted iMapperAdopted;


    private final AdoptedAnimalService animalService;


    @PostMapping("/saveAnimal")//solo save, sin animal
    @ResponseStatus(HttpStatus.CREATED)
    public AdoptedAnimal saveAnimal (@RequestBody @Valid AdoptedAnimalDTO adoptedDTO) {
        return animalService.save(iMapperAdopted.dtoToModel(adoptedDTO));
    }

    @GetMapping("/getAllAnimals")
    public ResponseEntity<List<AdoptedAnimalDTO>> findAllAnimals() {
        return new ResponseEntity(iMapperAdopted.modelsToDtos(animalService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/getAnimalId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdoptedAnimalDTO findById(@PathVariable(value = "id") Integer id) {
        return iMapperAdopted.modelToDto(animalService.findById(id));
    }

    @DeleteMapping("/deleteAnimal/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Integer id) {
        AdoptedAnimalDTO adoptedDTO = iMapperAdopted.modelToDto(animalService.findById(id));
        animalService.deleteById(adoptedDTO.getIdAnimal());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateAnimal")
    public ResponseEntity <Object> updateAnimal (@RequestBody AdoptedAnimalDTO adoptedDTO){
        return new ResponseEntity<>(animalService.update(iMapperAdopted.dtoToModel(adoptedDTO)),HttpStatus.OK);
    }

}






