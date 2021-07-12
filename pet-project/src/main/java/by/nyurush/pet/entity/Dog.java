package by.nyurush.pet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "Dog")
@DiscriminatorValue("Dog")
public class Dog extends Pet {

    private DogBreed dogBreed;

}

