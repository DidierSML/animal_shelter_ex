package com.example.refugio.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
@Entity
@Table(name = "adopted_animals")
public class AdoptedAnimal {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="adopted_id")
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
