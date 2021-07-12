package by.nyurush.pet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "Cat")
@DiscriminatorValue("Cat")
public class Cat extends Pet {

    private CatBreed catBreed;

}
