package by.nyurush.pet.repository;

import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.DogBreed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findAllByDogBreed(DogBreed dogBreed);
}
