package com.example.refugio.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalForAdoptionDTO {

    private Integer idAnimal;
    private String name;
    private int age;
    private String specie;
}
