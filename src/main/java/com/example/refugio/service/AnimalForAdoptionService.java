package com.example.refugio.service;

import com.example.refugio.model.AnimalForAdoption;
import com.example.refugio.repository.AnimalForAdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class AnimalForAdoptionService {

    @Autowired
    private AnimalForAdoptionRepository animalForAdoptionRepository;

    public AnimalForAdoption save(AnimalForAdoption animal){ return animalForAdoptionRepository.save(animal);}
    public List<AnimalForAdoption> findAll(){
        return animalForAdoptionRepository.findAll();
    }
    public Optional<AnimalForAdoption> findById (Integer id){
        return animalForAdoptionRepository.findById(id);
    }

    public void deleteById (Integer id){ animalForAdoptionRepository.deleteById(id);}

    public AnimalForAdoption update (AnimalForAdoption animal) {return animalForAdoptionRepository.save(animal);}
}





//public ResponseEntity delete (Integer id) {
//    Response response = new Response();
//    Optional<AnimalInAdoption> optional = animalInAdoptionRepository.findById(id);
//        if (optional.isEmpty()) {
//                response.setStatusCode("400");
//                response.setStatusMsg("NOT_FOUND");
//                }else{
//                animalInAdoptionRepository.deleteById(id);
//                response.setStatusCode("200");
//                response.setStatusMsg("Animal has been deleted");
//                }
