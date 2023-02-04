package com.example.refugio.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name = "animals_for_adoption")
public class AnimalForAdoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="for_adoption_id")
    private Integer idAnimal;

    @NotBlank(message = "must not be blank")
    @Size(min=3,max=10, message = "Name must be at least 3 Characters long and 10 as maximum")
    private String name;

    @Min(0)
    @Max(30)
    private int age;

    @NotBlank(message = "must not be blank")
    @Size(min=4,max=10, message = "Name must be at least 3 Characters long and 10 as maximum")
    private String specie;


}
