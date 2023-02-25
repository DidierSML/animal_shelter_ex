package com.example.refugio.controller;
import com.example.refugio.dto.AdoptedAnimalDTO;
//import com.example.refugio.exceptions.Response;
import com.example.refugio.mapper.IMapperAdopted;
import com.example.refugio.model.AdoptedAnimal;
import com.example.refugio.service.AdoptedAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adopted")

public class AdoptedAnimalController {

    @Autowired
    private IMapperAdopted iMapperAdopted;

    @Autowired
    private AdoptedAnimalService animalService;


    @PostMapping("/saveAnimal")
    public ResponseEntity<AdoptedAnimal> saveAnimal (@RequestBody AdoptedAnimalDTO adoptedDTO) {
        return new ResponseEntity<>(animalService.save(iMapperAdopted.dtoToModel(adoptedDTO)), HttpStatus.CREATED);
    }

    @GetMapping("/getAllAnimals")
    public ResponseEntity<List<AdoptedAnimalDTO>> findAllAnimals() {
        return new ResponseEntity(iMapperAdopted.modelsToDtos(animalService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/getAnimalId/{id}")
    public ResponseEntity<Optional<AdoptedAnimalDTO>> findById(@PathVariable(value = "id") Integer id) { ///value off
        return new ResponseEntity(iMapperAdopted.modelToDto(animalService.findById(id).get()), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteAnimal/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Integer id) {
        AdoptedAnimalDTO adoptedDTO = iMapperAdopted.modelToDto(animalService.findById(id).get());
        animalService.deleteById(adoptedDTO.getIdAnimal());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateAnimal")
    public ResponseEntity <Object> updateAnimal (@RequestBody AdoptedAnimalDTO adoptedDTO){
        return new ResponseEntity<>(animalService.update(iMapperAdopted.dtoToModel(adoptedDTO)),HttpStatus.OK);///////
    }

    


}




//    @PutMapping("/updateAnimal")
//    public ResponseEntity <Object> updateAnimal (@RequestBody AnimalAdopted animal){
//        animalService.update(animal);
//        return new ResponseEntity<>(animalService.save(animal),HttpStatus.OK);///////
//    }






//    @DeleteMapping("/deleteAnimal/{id}")
//    public ResponseEntity<Void> deleteAnimal(@PathVariable Integer id) {
//        AnimalAdoptedDTO adoptedDTO = iMapper.modelToDto(animalService.)
//        animalService.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }



    




//@PatchMapping("/updateAnimal/{id}")
//    public ResponseEntity<Optional> updateAnimalById (@PathVariable Integer id){
//        Optional response = animalService.get(id);
//
//        if(response.isEmpty()){
//            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
//        }else {
//            return new ResponseEntity<>(animalService.get(id), HttpStatus.OK);
//        }
//    }


//    @PatchMapping("/updateAnimalByid")
//    public ResponseEntity updateAnimal(@RequestBody AnimalAdopted animalAdopted, @PathVariable Integer id){
//        try{
//            Optional<AnimalAdopted> searchAnimal = animalService.get(id);
//            animalService.save(animalAdopted);
//            return new ResponseEntity<AnimalAdopted>(an)
//        }catch (Exception exception){
//            return new ResponseEntity<AnimalAdopted>(HttpStatus.NOT_FOUND);
//        }
//
//    }






//Comprobados sin DTO:_________________________________________________________________________

//    @PostMapping("/saveAnimal")
//    public ResponseEntity<AnimalAdopted> saveAnimal(@RequestBody AnimalAdopted animal) {
//        return new ResponseEntity<>(animalService.save(animal), HttpStatus.CREATED);
//
//    }

//    @GetMapping("/getAllAnimals")
//    public ResponseEntity<List<AnimalAdopted>> findAllAnimals() {
//        return new ResponseEntity<>(animalService.findAll(), HttpStatus.OK);
//    }

//    @DeleteMapping("/deleteAnimal/{id}")
//    public ResponseEntity deleteAnimal(@PathVariable Integer id) {
//    animalService.delete(id);
//    return new ResponseEntity<>(HttpStatus.OK);
//}

//    @GetMapping("/getAnimal/{id}")
//    public ResponseEntity<Optional> findAnimalById(@PathVariable Integer id) {
//        Optional response = animalService.get(id);
//
//        if (response == null) {
//            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(animalService.get(id), HttpStatus.FOUND);
//        }
//    }

