package com.example.refugio.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdoptedAnimalDTO {

    private Integer idAnimal;

    private String name;
    private int age;
    private String specie;

}
